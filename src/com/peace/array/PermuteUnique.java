package com.peace.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/05/19
 * Time:    10:05 PM
 */
public class PermuteUnique {

  public List<List<Integer>> permutate(int nums[]){
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums,result, 0);
    return result;
  }
  public void  backtrack(int nums[],List<List<Integer>> result ,int start ) {
    if (start == nums.length) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int n :nums) list.add(n);
      result.add(list);
    }

    HashSet<Integer> set = new HashSet<>();

    for (int i = start; i < nums.length ; i++) {
      if (set.contains(nums[i])) continue;
      set.add(nums[i]);
      exchange(nums,start,i);
      backtrack(nums, result,start+1);
      exchange(nums,start,i);
    }


  }

  public void exchange(int [] nums, int i , int j) {
    Integer t = nums[i];
    nums[i] = nums[j];
    nums[j] =t;

  }

  public static void main(String[] args) {
    PermuteUnique pu = new PermuteUnique();
    int nums [] = {1,2,2};
    List<List<Integer>> result = pu.permutate(nums);
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }
}
