package com.greenfox.dorinagy.chatapp.model;

/**
 * Created by Nagy Dóra on 2017.05.22..
 */
public class FrontEndError {

  static String message;

  public FrontEndError(String message) {
    this.message = message;
  }

  public static String getMessage() {
    return message;
  }

  public static void setMessage(String message) {
    FrontEndError.message = message;
  }
}
