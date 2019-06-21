package com.peace.array;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/06/19
 * Time:    11:34 PM
 *
 *  https://leetcode.com/problems/trapping-rain-water/submissions/
 *
 */
public class TrappingWater {

  public int maximumVolumeOfWaterStored(int [] height) {
    if (height.length == 0 ||height.length < 2) return 0;
    int maxAmountStored = 0;
    for (int i = 1; i < height.length - 1 ; i++) {
      int maxLeft = 0;
      for (int j = i; j >=0 ; j--) {
        maxLeft = Math.max(maxLeft,height[j]);
      }

      int maxRight = 0;
      for (int j = i; j < height.length; j++) {
        maxRight = Math.max(maxRight, height[j]);
      }

      maxAmountStored += Math.min(maxLeft,maxRight);
    }
    return maxAmountStored;
  }

  public static int optimalOne( int [] height) {
    int n = height.length;
    if (n == 0 || n < 2) return 0;
    int maxAmountStored = 0;

    int [] maxLeftSeen = new int[n];
    int [] maxRightSeen = new int[n];
    maxLeftSeen[0] = height[0];
    for (int i = 1; i < n; i++) {
      maxLeftSeen[i] = Math.max(maxLeftSeen[i-1],height[i]);
    }

    maxRightSeen[n-1] = height[n-1];
    for (int i = n-2; i >= 0 ; i--) {
      maxRightSeen[i] = Math.max(maxRightSeen[i+1],height[i]);
    }

    for (int i = 0; i < n; i++) {
      maxAmountStored += Math.min(maxLeftSeen[i], maxRightSeen[i]) - height[i];
    }
    return maxAmountStored;
  }

  public static void main(String[] args) {
    int height [] = {2,0,2};
    System.out.println(optimalOne(height));
  }
}
