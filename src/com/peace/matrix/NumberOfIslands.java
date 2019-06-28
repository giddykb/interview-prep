package com.peace.matrix;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/06/19
 * Time:    12:40 AM
 */
public class NumberOfIslands {



  static int[][] dirs = { {0,-1},{0,1},{-1,0},{1,0}};

  public static int numIslands( int [][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int r = grid.length;
    int c = grid[0].length;
    boolean [][] isVisited = new boolean [r][c];

    int count = 0;
    for (int i = 0; i <r ; i++) {
      for (int j = 0; j < c; j++) {
        if (!isVisited[i][j] && grid[i][j] == 1) {
          dfs(grid,i,j,isVisited);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs( int [][] grid, int r , int c,boolean [][] isVisited) {
    if (r < 0 || c < 0 || r >= grid.length ||  c >= grid[0].length || grid[r][c] == 0 || isVisited[r][c]) return;
    isVisited[r][c] = true;
    for (int [] dir : dirs) {
      int x = r + dir[0];
      int y = c + dir[1];
      dfs(grid,x,y,isVisited);
    }
  }

  public static void main(String[] args) {
    int grid [][]= {
        {1,1,1,0},
        {1,1,0,0},
        {1,1,0,0},
        {0,0,0,0}
    };
    System.out.println(numIslands(grid));
  }
}
