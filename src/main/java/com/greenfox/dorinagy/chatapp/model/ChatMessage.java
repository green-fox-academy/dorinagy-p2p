package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Entity
@Component
@Table(name="chattable")
public class ChatMessage {

  @Id
  private int id = setRandomId();
  private String username;
  private String text;
  private Timestamp timestamp = new Timestamp(System.currentTimeMillis());;

  public ChatMessage() {
  }

  public int setRandomId() {
    Random random = new Random();
    return random.nextInt(9999999 - 1000000 + 1) - 1000000;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
