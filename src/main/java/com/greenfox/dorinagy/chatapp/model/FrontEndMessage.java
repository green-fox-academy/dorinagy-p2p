package com.greenfox.dorinagy.chatapp.model;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
public class FrontEndMessage {

  static String message = "";

  public FrontEndMessage(String message) {
    this.message = message;
  }

  public static String getMessage() {
    return message;
  }

  public static void setMessage(String message) {
    FrontEndMessage.message = message;
  }
}
