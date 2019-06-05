package com.peace.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    24/05/19
 * Time:    8:25 PM
 */
public class Permutations {

  public List<List<Integer>> permutate(Integer nums[]){
    List<List<Integer>> result = new ArrayList<>();
    permutate(nums,result, 0);
    return result;
  }

  public void permutate(Integer nums[],List<List<Integer>> result,  int start){
    if (start == nums.length){
      List<Integer> res = Arrays.asList(nums.clone());
      result.add(res);
    }

    for (int i = start; i < nums.length; i++) {
      exchange(nums, start,i);
      permutate(nums, result, start+1);
      exchange(nums,start,i);
    }
  }



  public void exchange(Integer [] nums, int i , int j) {
    Integer t = nums[i];
    nums[i] = nums[j];
    nums[j] =t;

  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute(nums, result, new ArrayList());
    return result;
  }

  public void permute( int []nums, List<List<Integer>> result , List<Integer> tempList) {
    if( tempList.size() == nums.length) {
      result.add(new ArrayList(tempList));
    }

    for(int i=0; i< nums.length;i++) {
      if(tempList.contains(nums[i])) continue;
      tempList.add(nums[i]);
      permute(nums, result, tempList);
      tempList.remove(tempList.size()-1);
    }
  }
  public static void main(String[] args) {

    Permutations p = new Permutations();
    //Integer nums [] = {1,2,3};
    //List<List<Integer>> result = p.permutate(nums);
    int nums [] = {1,2,3};

    List<List<Integer>> result = p.permute(nums);
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }
}
