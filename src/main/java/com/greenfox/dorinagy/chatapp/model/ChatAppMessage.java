package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Entity
@Component
public class ChatAppMessage {

  @Id
  private long id;
  private String username;
  private String text;
  private Timestamp timestamp;

  public long getId() {
    return id;
  }

  public void setId() {
    this.id = getRandomNumber();
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

  public long getRandomNumber() {
    return (1000000 + (long) (Math.random() * 9000000));
  }
}
