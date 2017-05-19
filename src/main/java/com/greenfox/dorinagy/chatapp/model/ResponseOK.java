package com.greenfox.dorinagy.chatapp.model;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
public class ResponseOK implements ResponseObject {

  private String status;

  public ResponseOK() {
    this.status = "ok";
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
