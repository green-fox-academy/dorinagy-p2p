package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Entity(name="usertable")
@Component
public class ChatAppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String username;

  public ChatAppUser() {
  }

  public ChatAppUser(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
