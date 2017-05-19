package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.FrontEndMessage;
import com.greenfox.dorinagy.chatapp.model.ResponseOK;
import com.greenfox.dorinagy.chatapp.model.TransferMessage;
import com.greenfox.dorinagy.chatapp.service.ChatMessageService;
import com.greenfox.dorinagy.chatapp.service.LogMessageService;
import com.greenfox.dorinagy.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    model.addAttribute("frontendmessage", FrontEndMessage.getMessage());
    model.addAttribute("messagelist", chatMessageService.getMessages());
    return "index";
  }

  @GetMapping("/enter")
  public String enter(Model model) {
    model.addAttribute("frontendmessage", FrontEndMessage.getMessage());
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


  //String url = "https://phorv1chatapp.herokuapp.com";
 // RestTemplate restTemplate = new RestTemplate();


  @PostMapping(value="sendmessage")
  public String addMessage(String message) throws Exception {
    chatMessageService.addNewChatMessage(message);

    TransferMessage transferMessage = new TransferMessage();

    //ResponseOK responseOK = restTemplate.postForObject(url, transferMessage, ResponseOK.class);

    chatMessageService.addNewReceivedMessage(transferMessage);
    //System.out.println(responseOK);

    return "redirect:/";
  }
}
