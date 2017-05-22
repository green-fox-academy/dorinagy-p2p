package com.greenfox.dorinagy.chatapp.model;

/**
 * Created by Nagy Dóra on 2017.05.22..
 */
public class JsonReceived {

  ChatAppMessage message;
  Client client;

  public JsonReceived() {
  }

  public ChatAppMessage getMessage() {
    return message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setMessage(ChatAppMessage message) {
    this.message = message;
  }
}
