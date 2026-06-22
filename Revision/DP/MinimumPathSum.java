package Revision.DP;
import java.util.Arrays;

public class MinimumPathSum {
    static class Solution {


    /*

    // Recursion

    public int recurse(int r,int c,int[][] grid){
        if(r>=grid.length || c >= grid[0].length) return Integer.MAX_VALUE;

        if(r == grid.length-1 && c == grid[0].length-1) return grid[r][c];

        int down = recurse(r+1,c,grid);

        int right = recurse(r,c+1,grid);

        return grid[r][c] + Math.min(down,right);
    }

    public int minPathSum(int[][] grid) {
        return recurse(0,0,grid);
    }

    */

    /*

    // Memo

    public int recurse(int r,int c,int[][] grid,int[][] memo){
        if(r>=grid.length || c >= grid[0].length) return Integer.MAX_VALUE;

        if(r == grid.length-1 && c == grid[0].length-1) return grid[r][c];

        if(memo[r][c] != -1) return memo[r][c];

        int down = recurse(r+1,c,grid,memo);

        int right = recurse(r,c+1,grid,memo);

        return memo[r][c] = grid[r][c] + Math.min(down,right);
    }

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int[] memos : memo){
            Arrays.fill(memos,-1);
        }
        return recurse(0,0,grid,memo);
    }

    */

    
    /*

    // Bottom Up

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        // Base case
        dp[r-1][c-1] = grid[r-1][c-1];

        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                
                if(j<c-1) dp[i][j] = grid[i][j] + dp[i][j+1];

                if(i<r-1) dp[i][j] = grid[i][j] + dp[i+1][j];

                if(j<c-1 && i<r-1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        
        return dp[0][0];
    }


    // cleanest

    public int minPathSum(int[][] grid) {

    int r = grid.length;
    int c = grid[0].length;

    int[][] dp = new int[r][c];

    for (int i = r - 1; i >= 0; i--) {
        for (int j = c - 1; j >= 0; j--) {

            if (i == r - 1 && j == c - 1) {
                dp[i][j] = grid[i][j];
            }
            else if (i == r - 1) { // last row
                dp[i][j] = grid[i][j] + dp[i][j + 1];
            }
            else if (j == c - 1) { // last column
                dp[i][j] = grid[i][j] + dp[i + 1][j];
            }
            else { // interior cell
                dp[i][j] = grid[i][j] +
                           Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    }

    return dp[0][0];
}
    

    */

    // O(col) space

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[] dp = new int[c];

        // Base case
        dp[c-1] = grid[r-1][c-1];

        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){

                if(j<c-1 && i<r-1){
                    dp[j] = grid[i][j] + Math.min(dp[j],dp[j+1]);
                }
                else{
                    if(j==c-1 &&  i<r-1) dp[j] += ( grid[i][j] );   // down
                    if(j<c-1) dp[j] += ( grid[i][j] + dp[j+1] );  // right
                }
            }
        }
        
        return dp[0];
    }

    /*  Cleanest From Chatgpt
    for(int i=r-1;i>=0;i--){
    for(int j=c-1;j>=0;j--){

        if(i == r-1 && j == c-1)
            continue;

        if(i == r-1)
            dp[j] = grid[i][j] + dp[j+1];

        else if(j == c-1)
            dp[j] = grid[i][j] + dp[j];

        else
            dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
    }
}
     */

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {1,2},{1,1}
        };
        System.out.println(sol.minPathSum(grid));
    }
    
}
