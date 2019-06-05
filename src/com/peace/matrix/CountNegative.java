package com.peace.matrix;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    25/05/19
 * Time:    10:31 PM
 */
public class CountNegative {

  public static  int count( int M[][]){
    if(M.length == 0 || M == null) return 0;

    int r = M.length;
    int c = M[0].length;
    int count = 0;

    int i =0;
    int j = c-1;

    while (i<r && j>=0) {
      if(M[i][j] < 0) {
        count += (j+1);
        i++;
      } else {
        j--;
      }
    }

    return count;
  }

  public static void main(String[] args) {

    int[][] mat =
        {
            { -7, -3, -1, 3, 5 },
            { -3, -2,  2, 4, 6 },
            { -1,  1,  3, 5, 8 },
            {  3,  4,  7, 8, 9 }
        };

    System.out.println(count(mat));
  }
}
