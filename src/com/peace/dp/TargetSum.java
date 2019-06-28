package com.peace.dp;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/06/19
 * Time:    5:43 AM
 *
 *  https://evelynn.gitbooks.io/google-interview/target-sum.html
 *
 *  Target Sum
 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 Find out how many ways to assign symbols to make sum of integers equal to target S.
 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 Logic :

 Sum(P) - Sum(N) = S
 Sum(P) + Sum(N) + Sum(P) - Sum(N) = S + Sum(P) +Sum(N)
 2*  Sum(P) =  sum(nums) + S


 */
public class TargetSum {
  static  int res  = 0;

  public static int findWays(int nums [] , int S) {
    if (nums == null || nums.length == 0) return 0;

    int sum = 0 ;
    for (int i : nums) {
      sum += i;
    }
    int target = (sum + S)/2 ;
    if (sum < S  || (sum+S)%2 > 0) return 0;
    helper(nums,0,target);
    return res;

  }

  public static void helper( int nums [], int idx, int target) {
    if (idx  == nums.length) return;
    if (nums[idx] == target) {
      res++;
    }

    helper(nums,idx+1, target - nums[idx]);
    helper(nums,idx+1, target);
  }

  public static  int subSetSum( int nums[] , int S) {
    int dp [] = new int[S+1];
    dp[0] = 1;
    for (int i = 0; i <nums.length ; i++) {
      for (int j = S; j >=nums[i] ; j--) {
        dp[j] += dp[j-nums[i]];
      }
    }
    return dp[S];
  }

  public static int findTargetSumWAys(int nums [] , int S) {
    if (nums == null || nums.length == 0) return 0;

    int sum = 0 ;
    for (int i : nums) {
      sum += i;
    }
    int target = (sum + S)/2 ;
    if (sum < S  || (sum+S)%2 > 0) return 0;
    return subSetSum(nums,target);
  }

  public static void main(String[] args) {
    int nums [] ={1,1,1,1,1};
    int k = 3;
    System.out.println(findWays(nums,k));
    System.out.println(findTargetSumWAys(nums, k));
  }
}
