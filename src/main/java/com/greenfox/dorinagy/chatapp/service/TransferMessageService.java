package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.Client;
import com.greenfox.dorinagy.chatapp.model.Message;
import com.greenfox.dorinagy.chatapp.model.TransferMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class TransferMessageService {

  @Autowired
  TransferMessage transferMessage;

  @Autowired
  UserService userService;

  @Autowired
  Client client;

  public void transferOwnMessage(Message message) {
    transferMessage.setMessage(message);
    client.setId(userService.getActiveUser().getUsername());
    transferMessage.setClient(client);
  }

  public void transferReceivedMessage(Message message) {
    transferMessage.setMessage(message);
    client.setId(userService.getActiveUser().getUsername());
    transferMessage.setClient(client);
  }
}
