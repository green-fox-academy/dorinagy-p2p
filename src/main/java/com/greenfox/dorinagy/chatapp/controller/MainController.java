package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.LogMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Controller
public class MainController {

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public String errorHandler() {
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
}
