package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nagy Dóra on 2017.05.26..
 */
@Component
public class MessageResponse {

  private List<ChatAppMessage> messages;
  private Client client;

  public List<ChatAppMessage> getMessages() {
    return messages;
  }

  public void setMessages(List<ChatAppMessage> messages) {
    this.messages = messages;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
