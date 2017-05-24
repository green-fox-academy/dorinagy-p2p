package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.*;
import com.greenfox.dorinagy.chatapp.repository.MessageRepository;
import com.greenfox.dorinagy.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.Timestamp;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Controller
public class MainController {

  @Autowired
  UserRepository userRepository;
  @Autowired
  ChatAppUser nameOfUser;
  @Autowired
  ChatAppMessage chatAppMessages;
  @Autowired
  MessageRepository messagesRepository;
  @Autowired
  Client client;

  RestTemplate restTemplate = new RestTemplate();

  String chatAppUniqueId;
  String chatAppPeerAddress;

  public MainController() {
    this.chatAppUniqueId = System.getenv("CHAT_APP_UNIQUE_ID");
    this.chatAppPeerAddress = System.getenv("CHAT_APP_PEER_ADDRESSS");
  }

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public String notFound() {
    System.err.println("ERROR");
    return "redirect:/";
  }

  @GetMapping(value = "/")
  public String mainPage(Model model) {

    String currentLogLevel = System.getenv("CHAT_APP_LOGLEVEL");

    if (currentLogLevel != null && currentLogLevel.equals("INFO")) {
      System.out.println(new LogMessage("INFO", "/", "GET", ""));
      System.out.println(new Timestamp());
    }

    model.addAttribute("userentry", nameOfUser.getUsername());
    model.addAttribute("messages", messagesRepository.findAllByOrderByTimestampDesc());
    return "index";
  }

  @GetMapping(value = "/enter")
  public String registerPage(Model model) {
    model.addAttribute("userentry", nameOfUser.getUsername());
    return "enter";
  }

  @PostMapping(value = "/enter")
  public String addNewUser(@RequestParam(name = "userentry") String userentry) {
    if (userentry.equals("")) {
      return "redirect:/";
    }
    nameOfUser.setUsername(userentry);
    nameOfUser.setId(1l);
    userRepository.save(nameOfUser);
    return "redirect:/";
  }

  String url = "http://phorv1chatapp.herokuapp.com/api/message/receive";

  @PostMapping(value = "/send")
  public String addMessage(@RequestParam(name = "messages") String messages) {
    if(messages.equals("")) {
      return "redirect:/";
    }
    chatAppMessages.setId();
    chatAppMessages.setUsername(nameOfUser.getUsername());
    chatAppMessages.setText(messages);
    chatAppMessages.setTimestamp(new Timestamp(System.currentTimeMillis()));
    messagesRepository.save(chatAppMessages);

    client.setId("dorinagy");
    JsonReceived json = new JsonReceived();
    json.setMessage(chatAppMessages);
    json.setClient(client);
    restTemplate.postForObject(url, json, JsonReceived.class);
    return "redirect:/";
  }
}
