package com.peace.machine.coding.splitwise.service;

import com.peace.machine.coding.splitwise.entities.Group;
import com.peace.machine.coding.splitwise.entities.User;
import com.peace.machine.coding.splitwise.repositries.GroupRepositry;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:16 PM
 */

public class GroupService {
  GroupRepositry groupRepositry = new GroupRepositry();

  public void createGroup(Group group) {
    groupRepositry.add(group);
  }

  public void updateGroup(Group group) {
    groupRepositry.update(group);
  }

  public void deleteGroup(Group group) {
    groupRepositry.delete(group);
  }

  public void addUser(Group group, User user) {
    groupRepositry.addUser(group,user);
  }

  public  void deleteUser( Group group, User user) {
    groupRepositry.deleteUser(group,user);
  }

  public List<Group> getGroupsForUser(User user) {
    return groupRepositry.getAllGroupsForUser(user);
  }

}
