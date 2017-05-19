package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ResponseOK;
import com.greenfox.dorinagy.chatapp.model.ResponseObject;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.19..
 */
@Component
public class ResponseService {

  public ResponseObject statusOK() {
    return new ResponseOK();
  }
}
