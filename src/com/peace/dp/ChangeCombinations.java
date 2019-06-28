package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/06/19
 * Time:    1:14 AM
 *
 * https://leetcode.com/problems/coin-change-2/
 */
public class ChangeCombinations {

  static int totalCombinationWithoutRepetition(int coins[], int amount) {

    int dp [] = new int [amount+1];
    dp[0] =1;
    
    for (int coin: coins) {
      for (int i = coin; i <=amount ; i++) {
        dp[i] = dp[i] + dp[i-coin];
      }
    }

    return dp[amount];
  }


  public static void main(String[] args) {
    int coins [] = {1, 2, 5};
    int amount = 5;
    System.out.println(totalCombinationWithoutRepetition(coins,amount));

  }
}
