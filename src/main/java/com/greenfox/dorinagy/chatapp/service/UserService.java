package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatAppUser;
import com.greenfox.dorinagy.chatapp.model.FrontEndMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Component
public class UserService {

  @Autowired
  UserRepository userRepo;

  public String registerUser(String username) {
    if (username.equals("")) {
      FrontEndMessage.setMessage("The username field is empty.");
      return "redirect:/enter";
    }
    Iterable<ChatAppUser> users = userRepo.findAll();
    for (ChatAppUser user : users) {
      if (username.equals(user.getUsername())) {
        FrontEndMessage.setMessage("This user already exists");
        return "redirect:/enter";
      }
    }
    userRepo.save(new ChatAppUser(username));
    FrontEndMessage.setMessage("User saved.");
    return "redirect:/";
  }

  public String updateUser(String username) {
    if (username.equals("")) {
      FrontEndMessage.setMessage("The username field is empty.");
      return "redirect:/";
    }
    Iterable<ChatAppUser> users = userRepo.findAll();
    for (ChatAppUser user : users) {
      if (username.equals(user.getUsername())) {
        FrontEndMessage.setMessage("Welcome " + username + "!");
        return "redirect:/";
      }
    }
    userRepo.save(new ChatAppUser(username));
    FrontEndMessage.setMessage("This user doesn't exist. Please register.");
    return "redirect:/enter";
  }
}
