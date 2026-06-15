package Revision.DP;

public class UniquePathsII {
    static class Solution {

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

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(sol.uniquePathsWithObstacles(grid));
    }
}
