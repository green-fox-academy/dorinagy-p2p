package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.JsonReceived;
import com.greenfox.dorinagy.chatapp.model.Status;
import com.greenfox.dorinagy.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

  String url = "http://phorv1chatapp.herokuapp.com/api/message/receive";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody JsonReceived jsonReceived) {

    messagesRepository.save(jsonReceived.getMessage());
    restTemplate.postForObject(url, jsonReceived, JsonReceived.class);

    List<String> errors = new ArrayList<>();

    if (StringUtils.isEmpty(jsonReceived.getMessage().getText())) {
      errors.add("message.text");
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getUsername())) {
      errors.add("message.username");
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getTimestamp())) {
      errors.add("message.timestamp");
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getId())) {
      errors.add("message.id");
    }
    if (StringUtils.isEmpty(jsonReceived.getClient().getId())) {
      errors.add("client.id");
    }

    if (errors.size() == 0) {
      status.setStatus("ok");
    } else {
      status.setStatus("error");
      status.setMessage(errors);
    }

    return status;
  }
}
