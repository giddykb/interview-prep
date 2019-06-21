package com.peace.dp;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/06/19
 * Time:    12:09 AM
 */
public class KnapSackWithRepition {

  static  int maxValue( int wt[] , int v[],int capacity) {

    int n = wt.length;
    int T[] = new int[capacity+1];
    int R[] = new int[capacity+1];
    Arrays.fill(R,-1);

    for (int i = 0; i <n ; i++) {
      for (int j = 1; j <=capacity ; j++) {
        if (j >= wt[i] && T[j] < T[j-wt[i]]+ v[i]) {
          T[j] =  T[j-wt[i]]+ v[i];
          R[j] = i;
        }
      }
    }


    int start = R.length-1;
    while (start > 0) {
      int j = R[start];
      System.out.println(wt[j] +  ", " + v[j]);
      start = start - wt[j];
    }


    return T[capacity];

  }


  public static void main(String[] args) {
    int W = 100;
    int val[] = {10, 30, 20};
    int wt[] = {5, 10, 15};

    int capacity = 20;
    int [] amounts = {10,20};
    int[] calories = {100,150};

    //System.out.println(maxValue(wt,val,W));
    System.out.println(maxValue(amounts,calories,capacity));
  }
}
