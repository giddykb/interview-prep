package com.peace.machine.coding.vendingmachine.exceptions;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    8:32 PM
 */
public class InvalidDenominationException extends RuntimeException {
  private String message;

  public InvalidDenominationException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
