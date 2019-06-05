package com.peace.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/05/19
 * Time:    8:29 PM
 *
 * https://www.geeksforgeeks.org/find-two-missing-numbers-set-1-an-interesting-linear-time-solution/
 */
public class TwoMissingNumbers {


  static void solution(int arr[],int n) {

    int arrSum = Arrays.stream(arr).sum();
    int totalSum = n*(n+1)/2;
    int missingTwoSum = totalSum - arrSum;
    int avg = missingTwoSum/2;
    int smallerHalfSum = 0;
    int greaterHalfSum = 0 ;

    for (int i = 0; i <arr.length ; i++) {
      if (arr[i] <= avg) {
        smallerHalfSum += arr[i];
      }else {
        greaterHalfSum += arr[i];
      }
    }


    int totalSmallerHalfSum = avg *(avg+1)/2;
    int x = totalSmallerHalfSum - smallerHalfSum;
    System.out.println(x );
    System.out.println(missingTwoSum -x);
  }

  public static void main(String[] args) {
    int arr[] = {1, 3, 5, 6,2,4,9,10};
    solution(arr,10);
  }
}
