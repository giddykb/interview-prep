package com.peace.machine.coding.splitwise.service;

import com.peace.machine.coding.splitwise.entities.User;
import com.peace.machine.coding.splitwise.repositries.UserRepositry;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:16 PM
 */
public class UserService {
  UserRepositry userRepositry = new UserRepositry();

  public void addUser(User user) {
    userRepositry.add(user);
  }

  public void deleteUser(User user) {
    userRepositry.delete(user);
  }

  public void updateUser(User user) {
    userRepositry.update(user);
  }

  public Collection<User> getAllUsers(){
    return userRepositry.getAllUsers();
  }

}
