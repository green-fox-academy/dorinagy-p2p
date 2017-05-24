package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.JsonReceived;
import com.greenfox.dorinagy.chatapp.model.Status;
import com.greenfox.dorinagy.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@RestController
public class ChatAppRestController {

  @Autowired
  MessageRepository messagesRepository;

  @Autowired
  Status status;

  RestTemplate restTemplate = new RestTemplate();

  String url = "http://greenfox-chat-app.herokuapp.herokuapp.com/api/message/receive";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody JsonReceived jsonReceived) {

    messagesRepository.save(jsonReceived.getMessage());
    status.setStatus("ok");
    restTemplate.postForObject(url, jsonReceived, JsonReceived.class);

    return status;
  }
}
