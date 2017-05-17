package com.greenfox.dorinagy.chatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Controller
public class MainController {

  @RequestMapping("/")
  public String mainPage() {
    return "index";
  }
}
