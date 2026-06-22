package Revision.DP;
import java.util.Arrays;

public class MaximalSquare {
    static class Solution {

    /*

    // Recursion 
    public int recurse(int r,int c,char[][] mat){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length) return 0;

        if(mat[r][c] == '0') return 0;

        int right = recurse(r,c+1,mat);
        int down =  recurse(r+1,c,mat);
        int diagonal = recurse(r+1,c+1,mat);
        
        return 1+Math.min(diagonal,Math.min(right,down));
    }

    public int maximalSquare(char[][] matrix) {

        int area = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                int side = recurse(i,j,matrix);
                area = Math.max(area,side*side);
                }
            }
        }

        return area;
    }

    */

    

    /*

    // Memo

    public int recurse(int r,int c,char[][] mat,int[][] memo){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length) return 0;

        if(mat[r][c] == '0') return 0;

        if(memo[r][c] != -1) return memo[r][c];

        int right = recurse(r,c+1,mat,memo);
        int down =  recurse(r+1,c,mat,memo);
        int diagonal = recurse(r+1,c+1,mat,memo);
        
        return memo[r][c] = 1+Math.min(diagonal,Math.min(right,down));
    }

    public int maximalSquare(char[][] matrix) {

        int r=matrix.length,c=matrix[0].length;

        int[][] memo = new int[r][c];

        for(int[] memos : memo){
            Arrays.fill(memos,-1);
        }

        int area = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                int side = recurse(i,j,matrix,memo);
                area = Math.max(area,side*side);
                }
            }
        }

        return area;
    }

    */

    
    /*

    // Bottom Up

    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];

        int maxArea = 0;

        int dig=0,left=0,up=0;

        for(int i = r-1; i >= 0; i--){
            for(int j = c-1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    
                    if(i<r-1) up = dp[i+1][j];  // down

                    if(j<c-1) left = dp[i][j+1];  // right

                    if(i<r-1 && j<c-1) dig = dp[i+1][j+1];

                    dp[i][j] = 1 + Math.min(dig,Math.min(left,up));
                    
                    maxArea = Math.max(maxArea, dp[i][j]*dp[i][j]);

                    dig=0;
                    left=0;
                    up=0;
                   
                }
            }
        }

        return maxArea;
    }

    */

    // O(col) Space

    public int maximalSquare(char[][] matrix) {

    int r = matrix.length;
    int c = matrix[0].length;

    int[] dp = new int[c];
    int maxSide = 0;

    for (int i = r - 1; i >= 0; i--) {

        int prevDiag = 0;   // represents old dp[j+1] from row below

        for (int j = c - 1; j >= 0; j--) {

            int oldDown = dp[j];

            if (matrix[i][j] == '1') {

                int right = (j == c - 1) ? 0 : dp[j + 1];
                int down = oldDown;
                int diag = prevDiag;

                dp[j] = 1 + Math.min(diag, Math.min(right, down));

                maxSide = Math.max(maxSide, dp[j]);

            } else {
                dp[j] = 0;
            }

            prevDiag = oldDown;
        }
    }

    return maxSide * maxSide;
}

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] grid = {
            {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
        };
        System.out.println(sol.maximalSquare(grid));
    }
}
