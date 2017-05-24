package com.greenfox.dorinagy.chatapp.repository;

import com.greenfox.dorinagy.chatapp.model.ChatAppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Component
public interface UserRepository extends CrudRepository<ChatAppUser, Long> {
}
