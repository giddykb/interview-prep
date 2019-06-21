package com.peace.tesco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/05/19
 * Time:    10:50 AM
 */
public class Tesco {

  static  AtomicInteger maxCaloreisSoFar = new AtomicInteger();
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
    /*int amount = 4;
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
    }*/
    int capacity = 20;
    int [] amounts = {10,20};
    int[] calories = {100,150};
    System.out.println(maxCalories(capacity,amounts,calories));

  }


  static int maxCalories( int capacity , int [] amount, int[] calories) {
    HashMap<String,Integer> cache = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int res = maxCalories(capacity, amount, calories, cache, 0,list, new AtomicInteger());
    return res;
  }

  static int maxCalories(int capacity , int [] amount, int[] calories,
                         HashMap<String,Integer> cache, int idx, List<Integer> list, AtomicInteger caloriesSoFar) {
    if(idx == amount.length ||  capacity < 0) return 0;
    if (capacity == 0 &&  maxCaloreisSoFar.get() < caloriesSoFar.get()) {
      maxCaloreisSoFar = caloriesSoFar;
      System.out.println(list.toString());
      return caloriesSoFar.get();
    }
    if (amount[idx] > capacity) {
      return maxCalories(capacity, amount,calories,cache,idx+1,list,caloriesSoFar);
    }

    String key = idx+ "|"+ capacity;
    if (!cache.containsKey(key)) {
      list.add(idx);
      int include =
          maxCalories(capacity-amount[idx], amount, calories, cache, idx,list,new AtomicInteger(caloriesSoFar.addAndGet(calories[idx])));
      list.remove(list.size()-1);
      int exclude = maxCalories(capacity, amount,calories,cache,idx+1,list,new AtomicInteger(caloriesSoFar.addAndGet(-calories[idx])));
      cache.put(key,Math.max(include,exclude));
    }
    return cache.get(key);
  }

}
