package com.peace.machine.coding.splitwise.repositries;

import com.peace.machine.coding.splitwise.entities.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:17 PM
 */

public class UserRepositry {

  HashMap<Integer,User> userMap = new HashMap<>();

  public void add(User user) {
    userMap.put(user.getId(), user);
  }

  public void delete(User user) {
    userMap.remove(user.getId());
  }

  public void update(User user) {
    if(!userMap.containsKey(user.getId())){
      System.out.println("User doesn't exist");
      return;
    }
    add(user);
  }

  public Collection<User> getAllUsers(){
    return userMap.values();
  }


}
