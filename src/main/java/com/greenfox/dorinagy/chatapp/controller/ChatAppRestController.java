package com.greenfox.dorinagy.chatapp.controller;

import com.greenfox.dorinagy.chatapp.model.ResponseObject;
import com.greenfox.dorinagy.chatapp.model.TransferMessage;
import com.greenfox.dorinagy.chatapp.service.ChatMessageService;
import com.greenfox.dorinagy.chatapp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/api/message/receive")
  @CrossOrigin("*")
  public ResponseObject addNewReceivedMessage(@RequestBody TransferMessage transferMessage) {
    chatMessageService.addNewReceivedMessage(transferMessage);
    return responseService.statusOK();
  }
}
