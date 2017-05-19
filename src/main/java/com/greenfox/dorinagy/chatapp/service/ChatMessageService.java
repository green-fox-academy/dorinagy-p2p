package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatAppMessage;
import com.greenfox.dorinagy.chatapp.model.TransferMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Component
public class ChatMessageService {

  @Autowired
  ChatMessageRepository chatMessageRepo;

  @Autowired
  UserService userService;

  @Autowired
  TransferMessageService transferMessageService;

  public Iterable getMessages() {
    return chatMessageRepo.findAll();
  }

  public void addNewChatMessage(String text) {
    ChatAppMessage chatChatAppMessage = new ChatAppMessage();
    chatChatAppMessage.setUsername(userService.getActiveUser().getUsername());
    chatChatAppMessage.setText(text);
    chatMessageRepo.save(chatChatAppMessage);
    transferMessageService.transferOwnMessage(chatChatAppMessage);
  }

  public void addNewReceivedMessage(TransferMessage transferMessage) {
    ChatAppMessage chatAppMessage = new ChatAppMessage();
    chatAppMessage.setId(transferMessage.getMessage().getId());
    chatAppMessage.setText(transferMessage.getMessage().getText());
    chatAppMessage.setUsername(transferMessage.getMessage().getUsername());
    chatAppMessage.setTimestamp(transferMessage.getMessage().getTimestamp());
    chatMessageRepo.save(chatAppMessage);
    transferMessageService.transferReceivedMessage(transferMessage);
  }
}
