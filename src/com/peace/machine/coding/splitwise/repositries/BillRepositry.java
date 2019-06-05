package com.peace.machine.coding.splitwise.repositries;

import com.peace.machine.coding.splitwise.entities.Bill;
import com.peace.machine.coding.splitwise.entities.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:18 PM
 */

public class BillRepositry {

  HashMap<Integer,Bill> billsRepo = new HashMap<>();
  HashMap<Integer,List<Bill>> groupBillsMapping = new HashMap<>();


  public void add(Bill bill) {
    billsRepo.put(bill.getId(), bill);
    groupBillsMapping.putIfAbsent(bill.getId(), new ArrayList<>());
    groupBillsMapping.get(bill.getId()).add(bill);
  }

  public void delete(Bill bill) {
    billsRepo.remove(bill.getId());
  }
  public void update(Bill bill) {
    add(bill);
  }

  public Bill get(long billNo) {
    return billsRepo.get(billNo);
  }

  public List<Bill> getAllBills() {
    return new ArrayList<>(billsRepo.values());
  }

  public List<Bill> getBillsForGroup(Group group) {
    return groupBillsMapping.get(group.getId());
  }

}
