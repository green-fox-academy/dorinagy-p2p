package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class Status {

  private String status;
  private List message;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }

  public List getMessage() {
    return message;
  }
}
