package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class Status {

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
