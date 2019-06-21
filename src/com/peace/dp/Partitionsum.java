package com.peace.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    19/06/19
 * Time:    9:15 PM
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class Partitionsum {

  public static boolean canPartition( int nums[]) {
    int sum = 0;
    for (int num : nums) {
      sum+=num;
    }
    if(sum%2 == 1) return false;
    sum = sum/2;

    boolean dp[][] = new boolean[nums.length+1][sum+1];
    for( int i=0 ; i<=nums.length;i++){
      for(int j=0;j<=sum;j++) {
        if(i==0) continue;
        else if(j==0) dp[i][0] =true;
        else if (j>=nums[i-1]) {
          dp[i][j]  =
              dp[i-1][j] || dp[i-1] [j-nums[i-1]];
        }
      }
    }
    print(dp);
    if (dp[nums.length][sum]) {
      printSolution(dp,nums);
    }
    return dp[nums.length][sum];
  }

  static void print(boolean dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (dp[i][j]) {
          System.out.print("T" );
        } else {
          System.out.print("F" );
        }
        System.out.print("   ");
      }
      System.out.println();
    }
  }

  static void printSolution(boolean dp[][] , int nums[]) {

    int i = dp.length-1;
    int j = dp[0].length-1;
    List<Integer> res= new ArrayList<>();
    while (i>0  && j >0) {
      while (dp[i][j]) {
        i=i-1;
      }
      res.add(nums[i]);
      j = j- nums[i];
    }

    System.out.println(res.toString());
  }

  public static void main(String[] args) {
    int nums[] = {4,1, 5, 3, 5, 4};
    System.out.println(canPartition(nums));
  }
}
