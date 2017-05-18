package com.greenfox.dorinagy.chatapp.model;

import javax.persistence.Entity;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
public class ChatMessage {

  private long id;
  private String username;
  private String text;

  public ChatMessage(String text) {
    this.text = text;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
