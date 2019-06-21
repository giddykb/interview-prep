package com.peace.dp;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    07/06/19
 * Time:    1:33 PM
 */
public class TotalWaysWithNsum {


  public static int count(int sum ,int n) {
    if (n == 0 && sum == 0) return 1;
    if (n < 0 || sum < 0 || n > sum || n*6 < sum) return 0;

    int count = 0;
    for (int i = 1; i <=6 ; i++) {
      count+= count(sum-i,n-1);
    }
    return count;

  }

  public static int topDown(int sum , int n, HashMap<String,Integer> cache) {
    if (n < 0 || sum < 0) return 0;
    if (n == 0 && sum == 0) return 1;
    String key = sum+ "|" + n;
    int count = 0;
    if (!cache.containsKey(key)) {
      for (int i = 1; i <=6 ; i++) {
        count+= count(sum-i,n-1);
      }
      cache.put(key,count);
    }
    return cache.get(key);

  }

  public static  int bottomUp(int sum, int n) {

    int dp [][] = new int [n+1][sum+1];
    for (int j = 1; j <=6  && j<=sum; j++) {
      dp[1][j] = 1;
    }
    for (int i = 2; i <=n ; i++) {
      for (int j = 1; j <=sum ; j++) {
        for (int k = 1; k< j && k <=6 ; k++) {
          dp[i][j] += dp[i-1][j-k];
        }
      }
    }
    return dp[n][sum];
  }

  public static void main(String[] args) {

    int sum = 15;
    int n = 4;
    System.out.println(count(sum,n));
    System.out.println(topDown(sum,n,new HashMap<String,Integer>()));
    System.out.println(bottomUp(sum,n));
  }
}
