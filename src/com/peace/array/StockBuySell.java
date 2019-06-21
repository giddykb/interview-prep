package com.peace.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    07/06/19
 * Time:    10:23 PM
 * https://www.geeksforgeeks.org/stock-buy-sell/
 * find local minima and local maxima until u reach the end of the array.
 */
public class StockBuySell {

  private static class Transaction {
    int buyOn;
    int sellOn;
  }


  public static  int maximizeProfit(int stockPrice[]) {

    int idx = 0;
    List<Transaction> transactions = new ArrayList<>();

    int days = stockPrice.length;
    while (idx <  days) {
      while ( idx < days-1 && stockPrice[idx+1] <= stockPrice[idx]){
        idx++;
      }
      if (idx == days-1) break;
      Transaction transaction = new Transaction();
      transaction.buyOn = idx++;
      while (idx < days && stockPrice[idx-1] <= stockPrice[idx]) {
        idx++;
      }
      transaction.sellOn = idx-1;
      transactions.add(transaction);
    }
    int totalProfit = 0;
    if (!transactions.isEmpty()){
      for (Transaction transaction : transactions) {
        int buyOn = transaction.buyOn;
        int sellOn = transaction.sellOn ;
        int profit = stockPrice[sellOn]-stockPrice[buyOn];
        System.out.println("Buy on " + buyOn + " day, Sell on " + sellOn );
        totalProfit += profit;
      }
    } else {
      System.out.println("Not profit possible");
    }
    return totalProfit;
  }

  public static void main(String[] args) {
    int [] stockPrice = {100, 180, 260, 310, 40, 535, 695};
    System.out.println(maximizeProfit(stockPrice));
  }
}
