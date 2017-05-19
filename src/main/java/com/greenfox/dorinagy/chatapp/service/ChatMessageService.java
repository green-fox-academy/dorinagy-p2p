package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.Message;
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
    Message chatMessage = new Message();
    chatMessage.setUsername(userService.getActiveUser().getUsername());
    chatMessage.setText(text);
    chatMessageRepo.save(chatMessage);
    transferMessageService.transferOwnMessage(chatMessage);
  }

  public void addNewReceivedMessage(TransferMessage transferMessage) {
    Message message = new Message();
    message.setId(transferMessage.getMessage().getId());
    message.setText(transferMessage.getMessage().getText());
    message.setUsername(transferMessage.getMessage().getUsername());
    message.setTimestamp(transferMessage.getMessage().getTimestamp());
    chatMessageRepo.save(message);
    transferMessageService.transferReceivedMessage(transferMessage);
  }
}
