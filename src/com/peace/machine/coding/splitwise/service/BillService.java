package com.peace.machine.coding.splitwise.service;

import com.peace.machine.coding.splitwise.entities.Bill;
import com.peace.machine.coding.splitwise.entities.Group;
import com.peace.machine.coding.splitwise.repositries.BillRepositry;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:16 PM
 */

public class BillService {
  BillRepositry billRepositry = new BillRepositry();

  public void addBill(Bill bill) {
    billRepositry.add(bill);
  }

  public void deleteBill(Bill bill) {
    billRepositry.delete(bill);
  }

  public Bill getBill( long billNo) {
    return billRepositry.get(billNo);
  }

  public void updateBill(Bill bill) {
    billRepositry.update(bill);
  }

  public List<Bill> getBillsForGroup(Group group) {
    return billRepositry.getBillsForGroup(group);
  }

  public List<Bill> getAllBills() {
    return billRepositry.getAllBills();
  }

}
