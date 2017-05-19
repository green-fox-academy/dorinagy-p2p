package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class TransferMessage {

  Message message;
  Client client;

  public TransferMessage() {
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
