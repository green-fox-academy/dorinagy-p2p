package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.ResponseObject;
import com.greenfox.dorinagy.chatapp.model.TransferMessage;
import com.greenfox.dorinagy.chatapp.service.ChatMessageService;
import com.greenfox.dorinagy.chatapp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@RestController
public class ChatAppRestController {

  @Autowired
  ChatMessageService chatMessageService;

  @Autowired
  ResponseService responseService;

  @PostMapping(value="sendmessage")
  public void addMessage(HttpServletResponse httpServletResponse, String message) throws Exception {
    chatMessageService.addNewChatMessage(message);
    httpServletResponse.sendRedirect("/");
  }

  @PostMapping("/api/message/receive")
  public ResponseObject addNewReceivedMessage(@RequestBody TransferMessage transferMessage) {
    chatMessageService.addNewReceivedMessage(transferMessage);
    return responseService.statusOK();
  }
}
