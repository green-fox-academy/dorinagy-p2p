package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.LogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Controller
public class MainController {

  @Autowired
  LogMessage logMessage;

  @RequestMapping("/")
  public String mainPage() {
    System.out.println((new LogMessage("/", "GET", "INFO", "")));
    return "index";
  }
}
