package com.peace.machine.coding.vendingmachine.enums;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    7:54 PM
 */
public enum Item {

  COKE("Coke", 25),
  PEPSI("Pepsi", 20);

  String name;
  int price;


  Item(String name, int price) {
    this.price = price;
    this.name = name;

  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

}
