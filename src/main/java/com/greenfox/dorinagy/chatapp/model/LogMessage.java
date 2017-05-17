package com.greenfox.dorinagy.chatapp.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
public class LogMessage {

  private String path;
  private String method;
  private LocalDateTime dateAndTime;
  private String logLevel;
  private String requestData;

  public LogMessage(String path, String method, String requestData) {
    this.path = path;
    this.method = method;
    this.dateAndTime = LocalDateTime.now();
    this.logLevel = "INFO";
    this.requestData = requestData;
  }

  public LogMessage() {

  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public LocalDateTime getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(LocalDateTime dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
    return dateAndTime.format(formatter)
            + " " + logLevel
            + " Request"
            + " " + path
            + " " + method
            + " " + requestData;
  }
}
