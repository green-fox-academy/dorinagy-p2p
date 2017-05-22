package com.greenfox.dorinagy.chatapp.service;

import com.greenfox.dorinagy.chatapp.model.ChatAppUser;
import com.greenfox.dorinagy.chatapp.model.FrontEndError;
import com.greenfox.dorinagy.chatapp.model.FrontEndOK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nagy Dóra on 2017.05.18..
 */
@Component
public class UserService {

  @Autowired
  UserRepository userRepo;

  private ChatAppUser activeUser;

  public String registerUser(String username) {
    if (username.equals("")) {
      FrontEndError.setMessage("The username field is empty.");
      return "redirect:/enter";
    }
    Iterable<ChatAppUser> users = userRepo.findAll();
    for (ChatAppUser user : users) {
      if (username.equals(user.getUsername())) {
        FrontEndError.setMessage("This user already exists");
        return "redirect:/enter";
      }
    }
    ChatAppUser userToRegister = new ChatAppUser((username));
    userRepo.save(userToRegister);
    activeUser = userToRegister;
    FrontEndOK.setMessage("User saved.");
    return "redirect:/";
  }

  public String updateUser(String username) {
    if (username.equals("")) {
      FrontEndError.setMessage("The username field is empty.");
      return "redirect:/";
    }
    Iterable<ChatAppUser> users = userRepo.findAll();
    for (ChatAppUser user : users) {
      if (username.equals(user.getUsername())) {
        FrontEndOK.setMessage("Welcome " + username + "!");
        return "redirect:/";
      }
    }
    FrontEndError.setMessage("This user doesn't exist. Please register.");
    return "redirect:/enter";
  }

  public ChatAppUser getActiveUser() {
    if(activeUser == null) {
      return userRepo.findOne(1l);
    } else
      return activeUser;
  }

  public void setActiveUser(ChatAppUser activeUser) {
    this.activeUser = activeUser;
  }
}
