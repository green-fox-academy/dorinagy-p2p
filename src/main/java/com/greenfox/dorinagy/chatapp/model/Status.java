package com.greenfox.dorinagy.chatapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
@JsonInclude(Include.NON_NULL)
public class Status {

  private String status;
  private String message;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setMessage(List<String> message) {
    this.message = "Missing field(s): ";
    for (String field : message) {
      this.message += field + ", ";
    }
    this.message = this.message.substring(0, this.message.length() - 2);
  }

  public String getMessage() {
    return message;
  }
}
