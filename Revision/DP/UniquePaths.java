package Revision.DP;
import java.util.Arrays;

public class UniquePaths {
    static class Solution {


    /*
    
    // Recursion

    public int recurse(int r,int c,int row,int col){

        if(r == row-1 && c == col-1) return 1;

        if(r >= row || c >= col) return 0;

        int down = recurse(r+1,c,row,col);

        int right = recurse(r,c+1,row,col);

        return down+right;
    }

    public int uniquePaths(int m, int n) {
        return recurse(0,0,m,n);
    }

    */


    /*
    
    // Memo

    public int recurse(int r,int c,int row,int col,int[][] dp){

        if(r == row-1 && c == col-1) return 1;

        if(r >= row || c >= col) return 0;

        if(dp[r][c] != -1) return dp[r][c];

        int down = recurse(r+1,c,row,col,dp);

        int right = recurse(r,c+1,row,col,dp);

        return dp[r][c] = down+right;
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for(int[] subDps : dp){
            Arrays.fill(subDps,-1);
        }
        return recurse(0,0,m,n,dp);

    }

    */


    /*
    // Bottom Up

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // Base case
        dp[m-1][n-1] = 1;
        
        for(int i=m-1;i>=0;i--){

           for(int j=n-1;j>=0;j--){
    
              if(i==m-1 && j==n-1) continue;
              
              if(j<n-1) dp[i][j] += dp[i][j+1];
              
              if(i<m-1) dp[i][j] += dp[i+1][j];

           }

        }

        return dp[0][0];

    }

    */


    //  O(n) space

    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];

        // Base case
        dp[n-1] = 1;
        
        for(int i=m-1;i>=0;i--){

           for(int j=n-1;j>=0;j--){
    
              if(j==n-1) continue;
              
              dp[j] += dp[j+1];

           }

        }

        return dp[0];

    }



    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3,7));
    }
}
