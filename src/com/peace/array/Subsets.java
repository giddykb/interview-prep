package com.peace.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    23/05/19
 * Time:    8:49 PM
 */
public class Subsets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>>  result = new ArrayList<>();
    subsets(nums,new ArrayList<>(),result, 0);
    return result;
  }

  public void subsets(int[] nums, List<Integer> tempList,
                                     List<List<Integer>>  result , int start) {
    result.add(new ArrayList<>(tempList));
    Arrays.sort(nums);
    for (int i = start; i < nums.length ; i++) {
      if( i > start && nums[i] == nums[i-1]) continue;
      tempList.add(nums[i]);
      subsets(nums,tempList,result, i+1);
      tempList.remove(tempList.size()-1);
    }
  }


  public List<List<Integer>> powerSet(int nums[]) {
    List<List<Integer>>  result = new ArrayList<>();
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < (1<<n) ; i++) {
      List<Integer> subset  = new ArrayList<>();
      for (int j = 0; j < n ; j++) {
        if((i & (1<<j)) > 0) {
          subset.add(nums[j]);
        }
      }
      result.add(subset);
    }
    return result;
  }

  public static void main(String[] args) {
    Subsets s = new Subsets();
    int nums [] = {1,2,3};
    List<List<Integer>>  subsets = s.subsets(nums);
    //List<List<Integer>>  subsets = s.powerSet(nums);
    for (List<Integer> subset : subsets) {
      System.out.println(subset);
    }



  }
}
