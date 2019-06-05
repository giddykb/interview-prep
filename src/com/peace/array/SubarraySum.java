package com.peace.array;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/06/19
 * Time:    9:16 PM
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 */
public class SubarraySum {


  public static int count(int arr[], int k) {
    int count = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (map.containsKey(sum -k)) {
        count += map.get(sum-k);
      }
      map.put(sum, map.getOrDefault(sum , 0) +1);
    }
    return count;
  }

  public static void main(String[] args) {
    int arr [] = {3, 4, -7, 1, 3, 3, 1, -4 };
    int k = 7;
    System.out.println(count(arr,k));
  }
}
