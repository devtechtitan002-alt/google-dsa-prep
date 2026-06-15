package Revision.DP;

public class MinimumFallingPathSum {
    static class Solution {

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
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {2,1,3},{6,5,4},{7,8,9}
        };
        System.out.println(sol.minFallingPathSum(grid));
    }
}
