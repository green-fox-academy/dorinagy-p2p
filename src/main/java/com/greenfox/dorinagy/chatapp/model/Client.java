package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class Client {

  private String id;

  public Client() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
