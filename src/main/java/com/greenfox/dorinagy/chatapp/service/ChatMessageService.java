package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatMessage;
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

  public Iterable getMessages() {
    return chatMessageRepo.findAll();
  }

  public void addNewChatMessage(String text) {
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setUsername(userService.getActiveUser());
    chatMessage.setText(text);
    chatMessageRepo.save(new ChatMessage());
  }
}
