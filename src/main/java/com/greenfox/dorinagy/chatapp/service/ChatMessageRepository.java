package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Component
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
  List<ChatMessage> findAll();
}
