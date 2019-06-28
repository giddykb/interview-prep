package com.peace.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/06/19
 * Time:    6:43 AM
 * https://evelynn.gitbooks.io/google-interview/max-consecutive-ones-ii.html
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 Example 1:
 Input: [1,0,1,1,0,1,1]
 Output: 4
 Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 After flipping, the maximum number of consecutive 1s is 4.

 */
public class MaxConsecutiveOnesII {

  public static int findMaxConsecutiveOnes(int[] nums) {

    if (nums == null || nums.length == 0) return 0;
    int l=0, r = 0;
    int nZeros = 0;
    int result = 0;
    while (r < nums.length) {
      if (nums[r] == 0) nZeros++;
      while (nZeros == 2) {
        while (nums[l] != 0) l++;
        l++;
        nZeros--;
      }

      result = Math.max(r-l+1,result);
      r++;
    }
    return result;
  }

  public static int findMaxConsecutiveOnes(int[] nums, int K) {
    if (nums == null || nums.length == 0) return 0;
    int l=0, r = 0;
    int result = 0;
    Queue<Integer> zeroesIndex = new LinkedList<>();
    while ( r < nums.length) {
      if (nums[r] == 0) {
        zeroesIndex.add(r);
      }
      if (zeroesIndex.size() > K) {
        l = zeroesIndex.poll()+1;
      }
      result = Math.max(result, r -l +1);
      r++;
    }
    return result;
  }
  
  public static void main(String[] args) {
    int nums [] = {1,0,0,1,1,0,1,1};
    System.out.println(findMaxConsecutiveOnes(nums));
    System.out.println(findMaxConsecutiveOnes(nums,2));

  }
}
