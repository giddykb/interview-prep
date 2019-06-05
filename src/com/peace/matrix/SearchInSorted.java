package com.peace.matrix;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/05/19
 * Time:    5:02 PM
 *
 *  https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
 */
public class SearchInSorted {

  public boolean searchMatrix(int[][] matrix, int target) {

    if (matrix.length == 0) return false;
    int r = matrix.length;
    int c = matrix[0].length;

    int  i = 0;
    int  j =  c-1;

    while( i < r && j >=0) {
      if(matrix[i][j] == target) return true;
      else if( target < matrix[i][j] ) {
        j--;
      } else {
        i++;
      }
    }

    return false;
  }


  public static void main(String[] args) {

  }
}
