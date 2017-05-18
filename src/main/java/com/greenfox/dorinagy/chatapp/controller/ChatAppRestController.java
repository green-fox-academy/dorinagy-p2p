package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@RestController
public class ChatAppRestController {

  @Autowired
  ChatMessageService chatMessageService;

  @PostMapping(value="sendmessage")
  public void addMessage(HttpServletResponse httpServletResponse, String message) throws Exception {
    chatMessageService.addNewChatMessage(message);
    httpServletResponse.sendRedirect("/");
  }
}
