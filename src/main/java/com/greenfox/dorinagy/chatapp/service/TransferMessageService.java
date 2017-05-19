package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class TransferMessageService {

  private String messageSendTo = "https://phorv1chatapp.herokuapp.com/api/message/receive";

  @Autowired
  TransferMessage transferMessage;

  @Autowired
  UserService userService;

  @Autowired
  Client client;

  @Autowired
  ChatAppUser chatAppUser;

  RestTemplate restTemplate;

  public TransferMessageService() {
    restTemplate = new RestTemplate();
  }

  public void transferOwnMessage(Message message) {
    transferMessage.setMessage(message);
    client.setId(userService.getActiveUser().getUsername());
    transferMessage.setClient(client);
    broadcast(transferMessage);
  }

  public void transferReceivedMessage(TransferMessage transferMessage) {
    if(transferMessage.getMessage().getUsername().equals(chatAppUser)) {
      broadcast(transferMessage);
    }
  }

  public void broadcast(TransferMessage transferMessage){
    ResponseOK responseObject = restTemplate.postForObject(messageSendTo, transferMessage, ResponseOK.class);
  }
}
