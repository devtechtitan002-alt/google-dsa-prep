package Revision.DP;
import java.util.Arrays;

public class MinimumFallingPathSum {
    static class Solution {

    /*

    // Recursion 

    public int recurse(int r,int c,int[][] grid){
        
        if(c < 0 || c >= grid[0].length)
        return Integer.MAX_VALUE;

    if(r == grid.length - 1)
        return grid[r][c];

    int left = recurse(r + 1, c - 1, grid);
    int down = recurse(r + 1, c, grid);
    int right = recurse(r + 1, c + 1, grid);

    return grid[r][c] + Math.min(left, Math.min(down, right));

    }
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;

        for(int i=0;i<matrix[0].length;i++){
           min = Math.min(min,recurse(0,i,matrix));
        }

        return min;
    }

    */

    /*

    // Memo

    public int recurse(int r,int c,int[][] grid,int[][] memo){
        
        if(c < 0 || c >= grid[0].length)
        return Integer.MAX_VALUE;

    if(r == grid.length - 1)
        return grid[r][c];

    if(memo[r][c] != -1) return memo[r][c];

    int left = recurse(r + 1, c - 1, grid,memo);
    int down = recurse(r + 1, c, grid,memo);
    int right = recurse(r + 1, c + 1, grid,memo);

    return memo[r][c] = grid[r][c] + Math.min(left, Math.min(down, right));

    }
    public int minFallingPathSum(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] memo = new int[r][c];

        for(int[] subMemos : memo){
            Arrays.fill(subMemos,-1);
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<matrix[0].length;i++){
           min = Math.min(min,recurse(0,i,matrix,memo));
        }

        return min;
    }

    */

    /*

    // Bottom Up

    public int minFallingPathSum(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];

        for(int j=0;j<c;j++){
            dp[r-1][j] = matrix[r-1][j];
        }

        int left=Integer.MAX_VALUE,down=Integer.MAX_VALUE,right=Integer.MAX_VALUE;

        for(int i=r-2;i>=0;i--){
           for(int j=0;j<matrix[0].length;j++){
              
                if(j>0) left = dp[i+1][j-1];

                down = dp[i+1][j];

                if(j<c-1) right = dp[i+1][j+1];

                dp[i][j] = matrix[i][j] + Math.min(down,Math.min(left,right));

           }

           left=Integer.MAX_VALUE;
           down=Integer.MAX_VALUE;
           right=Integer.MAX_VALUE;

        }

        int min = Integer.MAX_VALUE;

        for(int j=0;j<c;j++){
            min = Math.min(min,dp[0][j]);
        }

        return min;
    }

    */

    // O(Col) Space

    public int minFallingPathSum(int[][] matrix) {

        int r = matrix.length;
    int c = matrix[0].length;

    int[] dp = new int[c];

    // Base case: last row
    for (int j = 0; j < c; j++) {
        dp[j] = matrix[r - 1][j];
    }

    for (int i = r - 2; i >= 0; i--) {

        int[] temp = dp.clone();

        for (int j = 0; j < c; j++) {

            int left  = (j > 0)   ? temp[j - 1] : Integer.MAX_VALUE;
            int down  = temp[j];
            int right = (j < c - 1) ? temp[j + 1] : Integer.MAX_VALUE;

            dp[j] = matrix[i][j]+ Math.min(down, Math.min(left, right));
        }
    }

    int min = Integer.MAX_VALUE;

    for (int j = 0; j < c; j++) {
        min = Math.min(min, dp[j]);
    }

    return min;
    
    }
   
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {2,1,3},{6,5,4},{7,8,9}
        };
        System.out.println(sol.minFallingPathSum(grid));
    }
}
