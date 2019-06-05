package com.peace.slidwing.window;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/05/19
 * Time:    10:21 AM
 *
 * Given an array of integers of size ‘n’.
 Our aim is to calculate the maximum sum of ‘k’
 consecutive elements in the array.

 Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 k = 4
 Output : 39
 We get maximum sum by adding subarray {4, 2, 10, 23}
 of size 4.

 */
public class MaximumSum {

  public static  int maxSum(int arr[] , int k ) {
    if (arr.length ==0 || k == 0) return 0;

    int left  = 0, right = 0;
    int maxSum = Integer.MIN_VALUE;
    int sum = 0 ;
    while (right < arr.length) {
      sum += arr[right];
      maxSum = Math.max(sum,maxSum);
      right++;
      if (right-left == k) {
        sum = sum - arr[left];
        left++;
      }
    }
    return maxSum;
  }


  public static void main(String[] args) {
    int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
    int k = 4;
    System.out.println(maxSum(arr, k));
  }
}
