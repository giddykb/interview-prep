package com.peace.machine.coding.vendingmachine.enums;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    7:57 PM
 */
public enum Coin {
  PENNY(1),
  NICKLE(5),
  DIME(10),
  QUARTER(25);

  static HashMap<Integer, Coin> reverseMap = new HashMap<>();
  static {
    for (Coin coin: values()) {
      reverseMap.put(coin.getDenomination(), coin);
    }
  }
  private  int denomination;

  Coin(int denomination) {
    this.denomination = denomination;
  }

  public int getDenomination() {
    return denomination;
  }
  public boolean isValidDenomination(Coin coin) {
    return reverseMap.containsKey(coin.getDenomination());
  }
}
