package com.peace.matrix;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/05/19
 * Time:    5:17 PM
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search {

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;
    int r = matrix.length;
    int c = matrix[0].length;

    int i =0 ;
    int j = c-1;

    while(i < r && j>=0) {
      if( matrix[i][j] == target) return true;
      else if ( target > matrix[i][j] )  {
        i++;
      }
      else {
        return binarySearch(matrix,target,i,j);
      }
    }

    return false;
  }


  public static boolean binarySearch( int matrix[][], int target, int r , int c) {

    int lo = 0;
    int hi = c;
    while (lo <= hi) {
      int mid = lo + ((hi-lo)>>1);
      if (matrix[r][mid] == target) return true;
      else if (  target > matrix[r][mid]) lo = mid +1;
      else hi = mid-1;
    }
    return false;
  }


  public static void main(String[] args) {

    int matrix [][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    int target = 3;

    System.out.println(searchMatrix(matrix,target));

  }
}
