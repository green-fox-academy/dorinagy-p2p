package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatAppMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Component
public interface ChatMessageRepository extends CrudRepository<ChatAppMessage, Long> {
  List<ChatAppMessage> findAll();
}
