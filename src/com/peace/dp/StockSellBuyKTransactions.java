package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    08/06/19
 * Time:    6:04 PM
 */
public class StockSellBuyKTransactions {


  public  int maProfit(int prices[], int k ) {
    int days = prices.length;
    int dp[][] = new int [k+1][days];

    return dp[k][days-1];

  }
  public static void main(String[] args) {

  }
}
