package com.peace.machine.coding.splitwise.helper;

import com.peace.machine.coding.splitwise.entities.Bill;
import com.peace.machine.coding.splitwise.models.Contribution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    14/05/19
 * Time:    12:45 AM
 */
public class BalanceHelper {

  public static Map<Integer, Float> calculateBalanceForBills(List<Bill> bills) {
    Map<Integer, Float> balanceMap = new HashMap<>();
    for (Bill bill : bills) {
      List<Contribution> payableContribution = bill.getPaidUsers();
      for (Contribution contribution : payableContribution) {
        Integer userId = contribution.getUserId();
        float share = contribution.getShare();
        if(!balanceMap.containsKey(userId)) {
          balanceMap.put(userId,share);
        } else {
          balanceMap.put(userId,balanceMap.get(userId) + share);
        }
      }
      List<Contribution> paidContribution = bill.getPayableUsers();
      for (Contribution contribution : paidContribution) {
        Integer userId = contribution.getUserId();
        float share = contribution.getShare();
        if(!balanceMap.containsKey(userId)) {
          balanceMap.put(userId,share);
        } else {
          balanceMap.put(userId,balanceMap.get(userId) - share);
        }
      }
    }

    return balanceMap;
  }
}
