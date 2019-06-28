package com.peace.array;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/06/19
 * Time:    6:39 AM
 *
 * https://evelynn.gitbooks.io/google-interview/max-consecutive-one.html
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 */
public class MaxConsecuitveOnes {

  public static int findMaxConsecutiveOnes(int nums []) {
    if (nums == null || nums.length == 0) return 0;

    int result =0;
    int temp = 0;
    for (int i = 0; i <nums.length ; i++) {
      if (nums[i] ==1) temp++;
      else  {
        result = Math.max(result,temp);
        temp=0;
      }
    }

    return result = Math.max(result,temp);
  }


  public static void main(String[] args) {
    int nums [] = {1,1,0,1,1,0,1,1};
    System.out.println(findMaxConsecutiveOnes(nums));
  }
}
