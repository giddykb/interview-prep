package com.peace.machine.coding.splitwise.service;

import com.peace.machine.coding.splitwise.entities.Bill;
import com.peace.machine.coding.splitwise.entities.Group;
import com.peace.machine.coding.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    14/05/19
 * Time:    12:32 AM
 */

public class BalanceService {

  GroupService groupService = new GroupService();
  BillService billService = new BillService();

  public void  getOverallBalanceForUser(User user) {

  }


  public void getGroupWiseBalanceForUser(User user) {
     List<Group> userGroupsList = groupService.getGroupsForUser(user);
     List<Bill> userBills = new ArrayList<>();
     for (Group group : userGroupsList) {
       List<Bill> groupBills = billService.getBillsForGroup(group);
       userBills.addAll(groupBills);
     }


  }


}
