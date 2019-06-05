package com.peace.array;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/05/19
 * Time:    10:46 PM
 *
 *
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

  public static boolean canJump(int[] nums) {
    return canJump(nums,0);
  }

  public static boolean canJump(int[] nums,int idx) {
    if (idx == nums.length-1) return true;

    int furthestJump = Math.min(idx +nums[idx], nums.length-1);
      for (int j = idx+1; j <=furthestJump ; j++) {
        if (canJump(nums, j)) {
          return true;
        }
      }

    return false;
  }



  public static void main(String[] args) {
    int nums [] = {2,3,1,1,4};
    System.out.println(canJump(nums));
  }
}
