package com.peace.hackerrank;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/05/19
 * Time:    3:26 PM
 * String s = "tacocat"
 */
public class PalindromeCounter {


  static  int count = 0;

  public static  int count(String str) {

    for (int i = 0; i < str.length(); i++) {
      expandPalindrome(str,i,i);
      expandPalindrome(str,i, i+1);
    }
    return count;
  }

  public static void expandPalindrome(String str, int lo, int hi) {
    while (lo >=0  && hi < str.length() &&
        str.charAt(lo) == str.charAt(hi)) {
        count++;
        lo--;
        hi++;
    }
  }
  public static int countPalindrome(String str) {
    int count = 0;
    int n = str.length();
    boolean [][] dp  = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
      count++;
    }

    for (int i = 0; i < n-1 ; i++) {
      if (str.charAt(i) == str.charAt(i+1)) {
        dp[i][i+1] = true;
        count++;
      }
    }

    for (int l = 3; l <= n ; l++) {
      for (int i = 0; i < n-l+1; i++) {
        int j = i + l -1;
        if (str.charAt(i) == str.charAt(j) &&  dp[i+1] [j-1]) {
          dp[i][j] = true;
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    String str = "aaa";
    System.out.println(countPalindrome(str));
    System.out.println(count(str));
  }
}
