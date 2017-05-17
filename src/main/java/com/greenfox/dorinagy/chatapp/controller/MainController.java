package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.LogMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Controller
public class MainController {

  String chatAppUniqueId;
  String ChatAppPeerAdress;

  public MainController() {
    this.chatAppUniqueId = System.getenv("CHAT_APP_UNIQUE_ID");
    ChatAppPeerAdress = System.getenv("CHAT_APP_PEER_ADRESS");
  }

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public String errorHandler() {
    System.err.println("ERROR");
    return "redirect:/";
  }

  @RequestMapping("/")
  public String mainPage() {

    String currentLogLevel = System.getenv("CHAT_APP_LOGLEVEL");

    if(currentLogLevel != null && currentLogLevel.equals("INFO")) {
      System.out.println(new LogMessage("/", "GET", ""));
    }

    return "index";
  }

  @RequestMapping("/enter")
  public String register() {
    return "enter";
  }

  @PostMapping("/enter")
  public String redirect() {
    return "redirect:/";
  }
}
