package com.peace.machine.coding.vendingmachine.service;

import com.peace.machine.coding.vendingmachine.enums.Coin;
import com.peace.machine.coding.vendingmachine.enums.Item;
import com.peace.machine.coding.vendingmachine.utils.Bucket;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    8:15 PM
 */
public interface VendingMachineService {
  long selectItemAndGetPrice(Item item);
  void insertCoin(Coin coin);
  Bucket<Item, List<Coin>> collectItemAndChange(Item item);
  List<Coin> refund();
  void reset();
}
