package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.Username;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.17..
 */
@Component
public interface UserRepository extends CrudRepository<Username, Long> {
}
