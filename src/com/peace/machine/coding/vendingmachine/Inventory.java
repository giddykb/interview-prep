package com.peace.machine.coding.vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    8:02 PM
 */
public class Inventory<T> {

  HashMap<T, Integer> inventory = new HashMap<>();

  public void add(T item) {
    inventory.put(item, inventory.getOrDefault(item,0)+1);
  }

  public int getQuantity( T item) {
    if (inventory.containsKey(item)) {
      return inventory.get(item);
    }
    return 0;
  }

  public void deduct(T item) {
    if (hasItem(item)) {
      inventory.put(item, inventory.get(item)-1);
    }
  }

  public void clear() {
    inventory.clear();;
  }

  public  void put(T item, int quantity) {
    inventory.put(item,quantity);
  }

  public boolean hasItem(T item) {
    return getQuantity(item) > 0;
  }

  public Set<T> getAllItems() {
    return inventory.keySet();
  }

}
