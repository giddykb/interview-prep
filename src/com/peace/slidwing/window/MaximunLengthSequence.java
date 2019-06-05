package com.peace.slidwing.window;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/06/19
 * Time:    5:29 PM
 *
 * https://www.techiedelight.com/find-maximum-length-sequence-continuous-ones-sliding-window/
 */
public class MaximunLengthSequence {

  public static int maxLength(int arr[]) {

    int left = 0;
    int right = 0;
    int maxLength = -1;
    int count [] = new int[2];
    int  res[] = new int[3];
    while (right < arr.length) {
      count[arr[right]]++;
      if (count[0] == 2)  {
        while ( arr[left] != 0) {
          count[arr[left]]--;
          left++;
        }
        left++;
        count[0]--;
      }

      if (res[0] < right -left+1) {
        res[0] = right -left+1;
        res[1] = left;
        res[2] = right;
      }
      right++;
    }
    return res[0];
  }

  public static  int maxSequence(int arr[] , int k) {

    int left = 0;
    int right = 0;
    int count = 0;
    int  res[] = new int[3];
    while (right < arr.length) {
      if (arr[right] == 0) {
        count++;
      }
      if (count > k) {
        while (arr[left] != 0) {
          left++;
        }
        left++;
        count--;
      }
      if (res[0] < right - left + 1) {
        res[0] = right-left+1;
        res[1] = left;
        res[2] = right;

      }
      right++;
    }
    System.out.println("from index : " + res[1] + " to Index :: " + res[2]);
    return res[0];
  }


  public static void main(String[] args) {
    int arr []  = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
    int[] A = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
    int k = 1;
    System.out.println(maxSequence(A,k));
    System.out.println(maxLength(arr));
  }
}
