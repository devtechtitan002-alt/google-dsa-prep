package Revision.DP;

import java.util.Arrays;

public class UniquePathsII {
    static class Solution {


    /*
    // Recursion

    public int recurse(int r,int c,int row,int col,int[][] grid){

        if(r >= row || c >= col) return 0;

        if(grid[r][c] == 1) return 0;

        if(r == row-1 && c == col-1) return 1;

        int right = recurse(r,c+1,row,col,grid);

        int down = recurse(r+1,c,row,col,grid);

        return right+down;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         return recurse(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid);
    }

    */

    /*
    
    // Memo

    public int recurse(int r,int c,int row,int col,int[][] grid,int[][] dp){

        if(r == row-1 && c == col-1){  return grid[r][c] == 0 ? 1 : 0; }

        if(r >= row || c >= col) return 0;

        if(grid[r][c] == 1) return 0;

        if(dp[r][c] != -1) return dp[r][c];

        int right = recurse(r,c+1,row,col,grid,dp);

        int down = recurse(r+1,c,row,col,grid,dp);

        return dp[r][c] = right+down;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        int[][] dp = new int[r][c];
        for(int[] subDps : dp){
            Arrays.fill(subDps,-1);
        } 
        return recurse(0,0,r,c,obstacleGrid,dp);
    }

    */

    /*

    // Bottom Up

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        int[][] dp = new int[r][c];

        if(obstacleGrid[r-1][c-1] == 1) return 0;

        // Base Case
        dp[r-1][c-1] = 1;
        
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                
                if(obstacleGrid[i][j] == 1) continue;  // Don't calc for obstacles leave it as empty

                if(j<c-1) dp[i][j] += dp[i][j+1];

                if(i<r-1) dp[i][j] += dp[i+1][j];

            }
        }
        
        return dp[0][0];
    }

    */

    // O(col) space

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        int[] dp = new int[c];

        if(obstacleGrid[r-1][c-1] == 1) return 0;

        // Base Case
        dp[c-1] = 1;
        
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                
                if(obstacleGrid[i][j] == 1) { 
                    dp[j] = 0;  // Don't calc for obstacles leave it as empty
                    continue;
                }

                if(j<c-1) dp[j] += dp[j+1];

            }


        }
        
        return dp[0];
    }

    

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };

        int[][] grid1 = {
            {0,1},
            {0,0}
        };

        System.out.println(sol.uniquePathsWithObstacles(grid1));
    }
}
