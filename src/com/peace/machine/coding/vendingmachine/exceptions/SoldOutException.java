package com.peace.machine.coding.vendingmachine.exceptions;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    8:25 PM
 */
public class SoldOutException extends RuntimeException {

  private String message;

  public SoldOutException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
