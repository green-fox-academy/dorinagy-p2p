package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.FrontEndMessage;
import com.greenfox.dorinagy.chatapp.service.LogMessageService;
import com.greenfox.dorinagy.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Controller
public class MainController {

  @Autowired
  UserService userService;

  @Autowired
  LogMessageService logMessageService;

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

  @GetMapping("/")
  public String mainPage(HttpServletRequest httpServletRequest) {
    logMessageService.getinfo(httpServletRequest);
    return "index";
  }

  @GetMapping("/enter")
  public String register(HttpServletRequest httpServletRequest) {
    logMessageService.getinfo(httpServletRequest);
    return "enter";
  }

  @PostMapping("/enter")
  public String redirect(HttpServletRequest httpServletRequest, Model model, String username) {
    logMessageService.getinfo(httpServletRequest);
    model.addAttribute("username", username);
    model.addAttribute("frontendmessage", FrontEndMessage.getMessage());
    return userService.registerUser(username);
  }
}
