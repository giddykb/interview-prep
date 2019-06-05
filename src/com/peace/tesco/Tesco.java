package com.peace.tesco;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/05/19
 * Time:    10:50 AM
 */
public class Tesco {

  public static boolean canBeCheckedOut( int amount, int denominations[]) {

    HashMap<String, Boolean> cached = new HashMap<>();
    return canBeCheckedOut(amount, denominations, denominations.length -1,cached);
  }

  public static boolean canBeCheckedOut( int amount, int denominations[], int idx,
                                  HashMap<String, Boolean> cached) {
    if (amount == 0) return true;
    if (amount < 0 || idx < 0) return false;
    String key = idx + " | " + amount;
    if (!cached.containsKey(key)) {
      boolean include = canBeCheckedOut(amount - denominations[idx], denominations,
                                        idx - 1, cached);
      boolean exclude = canBeCheckedOut(amount, denominations, idx - 1, cached);
      cached.put(key, include || exclude);

    }
    return cached.get(key);

  }

  static  boolean validateDenomination ( int denomintations[] , int coin) {
    for (int i = 0; i <  denomintations.length; i++) {
      if( denomintations[i] == coin)  return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    int amount = 4;
    int coins[] = {1,2,3,5,7};
    int userInupt [] = {2,2,2};

    boolean isValidInput = true;
    for (int i = 0; i < userInupt.length ; i++) {
      if(!validateDenomination(coins,userInupt[i])) {
        isValidInput = false;
      }
    }
    if( isValidInput ) {
      System.out.println(canBeCheckedOut(amount, userInupt));
    } else  {
      System.out.println("denomination not accept");
    }

  }
}
