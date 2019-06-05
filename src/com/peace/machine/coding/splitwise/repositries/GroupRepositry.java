package com.peace.machine.coding.splitwise.repositries;

import com.peace.machine.coding.splitwise.entities.Group;
import com.peace.machine.coding.splitwise.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:17 PM
 */
public class GroupRepositry {

  HashMap<Integer, Group> groupRepositry = new HashMap<>();
  HashMap<Integer,List<Integer>> userGroupMapping = new HashMap<>();

  public void add(Group group) {
    groupRepositry.put(group.getId(), group);
  }

  public void update(Group group) {
    add(group);
  }

  public void delete(Group group) {
    List<User> users = group.getUsers();
    for (User user :users) {
      List<Integer> userGroups = userGroupMapping.get(user.getId());
      userGroups.removeIf(e-> e.equals(group.getId()));
    }
    groupRepositry.remove(group.getId());

  }


  public void addUser(Group group, User user) {

    groupRepositry.get(group.getId()).getUsers().add(user);
    userGroupMapping.putIfAbsent(user.getId(),new ArrayList<>());
    userGroupMapping.get(user.getId()).add(group.getId());

  }

  public void deleteUser(Group group, User user) {
    List<User> users = group.getUsers();
    users.removeIf( e ->  e.getId().equals(user.getId()));
    userGroupMapping.get(user.getId()).removeIf( v -> v.equals(group.getId()));
  }

  public Collection<Group> getAllGroups() {
    return groupRepositry.values();
  }


  public List<Group> getAllGroupsForUser(User user) {

    List<Integer> userGroups = userGroupMapping.get(user.getId());
    List<Group> groupList = new ArrayList<>();
    for (Integer groupId : userGroups) {
      groupList.add(groupRepositry.get(groupId));
    }
    return groupList;
  }



}
