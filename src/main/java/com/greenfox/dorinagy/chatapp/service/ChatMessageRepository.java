package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
}
