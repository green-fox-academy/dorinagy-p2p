package com.greenfox.dorinagy.chatapp.model;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
public class FrontEndOK {

  static String message = "";

  public FrontEndOK(String message) {
    this.message = message;
  }

  public static String getMessage() {
    return message;
  }

  public static void setMessage(String message) {
    FrontEndOK.message = message;
  }
}
