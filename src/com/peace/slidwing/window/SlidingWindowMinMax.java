package com.peace.slidwing.window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    07/06/19
 * Time:    2:40 PM
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMinMax {


  public static  int[] maximum(int nums[], int window) {
    if (nums.length == 0 || window <= 0) return new int[0];
    int [] res = new int[nums.length-window+1];
    Deque<Integer> deque = new LinkedList<>();

    int idx = 0;
    for (int i = 0; i <  nums.length; i++) {
      int curr = nums[i];
      while (!deque.isEmpty() && deque.peekFirst() < i-window+1) {
        deque.poll();
      }
      while (!deque.isEmpty() && curr > nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offer(i);
      if (i >= window-1) {
        res[idx++] = nums[deque.peekFirst()];
      }
      System.out.println(deque.toString());
    }
    return res;
  }


  public static  int[] minmum(int nums[], int window) {
    if (nums.length == 0 || window <= 0) return new int[0];
    int [] res = new int[nums.length-window+1];
    Deque<Integer> deque = new LinkedList<>();

    int idx = 0;
    for (int i = 0; i <  nums.length; i++) {
      int curr = nums[i];
      while (!deque.isEmpty() && deque.peekFirst() < i-window+1) {
        deque.poll();
      }
      while (!deque.isEmpty() && curr < nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offer(i);
      if (i >= window-1) {
        res[idx++] = nums[deque.peekFirst()];
      }
    }
    return res;
  }
  public static void main(String[] args) {
    int nums [] = {1,3,-1,-3,5,3,6,7};
    int window = 3;
    int result[]  = maximum(nums,window);
    System.out.println(Arrays.toString(result));
    result = minmum(nums, window);
    System.out.println(Arrays.toString(result));
  }
}
