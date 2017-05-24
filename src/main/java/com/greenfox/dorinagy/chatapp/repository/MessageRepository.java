package com.greenfox.dorinagy.chatapp.repository;

import com.greenfox.dorinagy.chatapp.model.ChatAppMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Component
public interface MessageRepository extends CrudRepository<ChatAppMessage, Long> {
  List<ChatAppMessage> findAllByOrderByTimestampDesc();
}
