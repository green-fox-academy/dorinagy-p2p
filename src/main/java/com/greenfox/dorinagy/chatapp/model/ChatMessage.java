package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Entity
public class ChatMessage {

  private long id;
  private String username;
  private String text;
  private Timestamp timestamp;

  public ChatMessage() {
    timestamp = new Timestamp(System.currentTimeMillis());
  }

  public ChatMessage(long id, String username, String text, Timestamp timestamp) {
    this.id = id;
    this.username = username;
    this.text = text;
    this.timestamp = timestamp;
  }

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

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}
