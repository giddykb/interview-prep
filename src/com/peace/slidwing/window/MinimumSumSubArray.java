package com.peace.slidwing.window;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/06/19
 * Time:    7:25 PM
 * https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/
 */
public class MinimumSumSubArray {

  public static int minSum( int arr [] , int k ) {

    int left = 0;
    int right = 0;
    int result = Integer.MAX_VALUE;
    int res[] = new int[3];
    int sum = 0;
    while (right < arr.length) {
      sum += arr[right];
      if (right - left+1 == k) {
        if (result > sum) {
          result = sum;
          res[0] = sum;
          res[1] = left;
          res[2] = right;
        }
        sum = sum - arr[left];
        left++;
      }
      right++;
    }
    System.out.println("from : " + res[1] + " to : " + res[2]);
    return result;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 4, 2, 5, 6, 3, 8, 1 };
    int k = 3;
    System.out.println(minSum(arr,k));
  }
}
