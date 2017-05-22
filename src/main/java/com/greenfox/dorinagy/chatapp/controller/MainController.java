package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.FrontEndError;
import com.greenfox.dorinagy.chatapp.model.FrontEndOK;
import com.greenfox.dorinagy.chatapp.model.TransferMessage;
import com.greenfox.dorinagy.chatapp.service.ChatMessageService;
import com.greenfox.dorinagy.chatapp.service.LogMessageService;
import com.greenfox.dorinagy.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

  @Autowired
  ChatMessageService chatMessageService;

  String chatAppUniqueId;
  String ChatAppPeerAdress;

  public MainController() {
    this.chatAppUniqueId = System.getenv("CHAT_APP_UNIQUE_ID");
    ChatAppPeerAdress = System.getenv("CHAT_APP_PEER_ADRESS");
  }

  @ModelAttribute
  public void getInfo(HttpServletRequest httpServletRequest) {
    logMessageService.getinfo(httpServletRequest);
  }

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public String errorHandler() {
    System.err.println("ERROR");
    return "redirect:/";
  }

  @GetMapping("/")
  public String mainPage(Model model) {
    model.addAttribute("frontendok", FrontEndOK.getMessage());
    model.addAttribute("frontenderror", FrontEndError.getMessage());
    model.addAttribute("messagelist", chatMessageService.getMessages());
    return "index";
  }

  @GetMapping("/enter")
  public String enter(Model model) {
    model.addAttribute("frontendok", FrontEndOK.getMessage());
    model.addAttribute("frontenderror", FrontEndError.getMessage());
    return "enter";
  }

  @GetMapping("/registeruser")
  public String register(@RequestParam(value="username") String username) {
    return userService.registerUser(username);
  }

  @GetMapping("/updateuser")
  public String update(@RequestParam(value="username") String username) {
    return userService.updateUser(username);
  }

  @PostMapping(value="sendmessage")
  public String addMessage(String message) throws Exception {
    chatMessageService.addNewChatMessage(message);
    TransferMessage transferMessage = new TransferMessage();
    chatMessageService.addNewReceivedMessage(transferMessage);
    return "redirect:/";
  }
}
