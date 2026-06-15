package Revision.DP;
import java.util.Arrays;

public class MinimumPathSum {
    static class Solution {

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
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {1,2,3},{4,5,6}
        };
        System.out.println(sol.minPathSum(grid));
    }
    
}
