package com.peace.array;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    20/06/19
 * Time:    9:59 PM
 *  https://www.geeksforgeeks.org/convert-to-strictly-increasing-integer-array-with-minimum-changes/
 */
public class StrictlyIncreasing {

  public static int minChanges(int nums[]) {

    int n = nums.length;
    int LIS[] = new int[n];

    for (int i = 0; i <n ; i++) {
      LIS[i] = 1;
    }

    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <i ; j++) {
        if (nums[j] < nums[i]) {
          LIS[i] = Math.max(LIS[i], 1+  LIS[j]);
        }
      }
      maxLen = Math.max(maxLen,LIS[i]);
    }
    System.out.println(maxLen);

    return  n-maxLen;
  }

  public static void main(String[] args) {
    int nums[] = {1, 2, 6, 5, 4};
    System.out.println(minChanges(nums));
  }
}
