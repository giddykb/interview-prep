package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    29/05/19
 * Time:    1:07 AM
 *
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 */
public class MinimumDeleteSum {

  static int minDeleteSum(String s1, String s2) {

    int dp [][]= new int[s1.length() + 1 ][ s2.length() + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length ; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = 0;
        }
        else if (i == 0){
          dp[i][j]  = s2.codePointAt(j-1) + dp[i] [j-1];
        }
        else if( j == 0 ) {
          dp[i][j] = s1.codePointAt(i-1) + dp[i-1] [j];
        }
        else if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i] [j] = dp[i-1][j-1];
        } else  {
          dp[i][j] = Math.min( dp[i-1][j] + s1.codePointAt(i-1),
                               dp[i][j-1] + s2.codePointAt(j-1));
        }
      }
    }
    return dp[s1.length()] [s2.length()];
  }

  public static void main(String[] args) {
    String s1 = "sea";
    String s2 = "eat";

    System.out.println(minDeleteSum(s1,s2));
  }
}
