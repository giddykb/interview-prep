package com.peace.matrix;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/05/19
 * Time:    10:45 AM
 *  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class KthSmallest {


  public static int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length ; j++) {
        pq.offer(matrix[i][j]);
        if(pq.size() > k) {
          pq.poll();
        }
      }
    }

    return !pq.isEmpty() ? pq.peek() : -1;
  }

  public static int kthSmallestOptimal(int[][] matrix, int k) {
      if (matrix.length == 0) return 0;

      int r = matrix.length;
      int c = matrix[0].length;
      int lo = matrix[0][0];
      int hi = matrix[r-1][c-1];
      while (lo < hi) {
        int mid = lo + (hi-lo)/2;
        int pos = getPost(matrix,mid);
        if (pos < k) {
          lo = mid+1;
        } else {
          hi = mid;
        }
      }
      return hi;
  }

  public static int getPost(int matrix[][], int target) {
    int r = matrix.length;
    int c = matrix[0].length;
    int pos = 0;

    for (int i = r-1, j=0; i>=0 && j <c;){
      if (matrix[i][j] <= target) {
        pos += i+1;
        j++;
      } else {
        i--;
      }
    }

      return pos;

  }

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15} };

    int k = 5;
    //System.out.println(kthSmallest(matrix,k));
    System.out.println(kthSmallestOptimal(matrix,k));


  }
}
