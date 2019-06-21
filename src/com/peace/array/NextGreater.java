package com.peace.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    07/06/19
 * Time:    5:36 PM
 */
public class NextGreater {

  public static void nextGreater(int nums[]) {
    if (nums.length == 0) return;

    Stack<Integer> stack = new Stack<>();
    int res[] = new int [nums.length];
    for (int i =  nums.length-1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      res[i] = stack.isEmpty()? -1: stack.peek();
      //System.out.println(nums[i] + " next  greater element :" + (stack.isEmpty()? -1: stack.peek()));
      stack.push(nums[i]);
    }
    System.out.println(Arrays.toString(res));
  }

  public static void nextGreaterCircular(int nums[]) {
    if (nums.length == 0) return;
    Stack<Integer> stack = new Stack<>();
    int res[] = new int [nums.length];
    for (int i = 2*nums.length-1; i >=0 ; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] <= nums[i%nums.length]) {
        stack.pop();
      }
      res[i%nums.length] = stack.isEmpty()? -1: nums[stack.peek()];
      stack.push(i%nums.length);
    }
    System.out.println(Arrays.toString(res));
  }

  public static void main(String[] args) {
    int nums [] = {13, 7, 6, 12};
    nextGreater(nums);
    nextGreaterCircular(nums);
  }
}
