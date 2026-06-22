package Revision.DP;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    static class Solution {


    /*
    // recursion

    public int recurse(int row,int idx,List<List<Integer>> triangle){
         if(row == triangle.size()-1) return triangle.get(row).get(idx);

         int down = recurse(row+1,idx,triangle);

         int adjacent = recurse(row+1,idx+1,triangle);

         return triangle.get(row).get(idx) + Math.min(down,adjacent);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return recurse(0,0,triangle);
    }

    */

    /*

    // Memo

    public int recurse(int row,int idx,List<List<Integer>> triangle,int[][] memo){
         if(row == triangle.size()-1) return triangle.get(row).get(idx);

         if(memo[row][idx] != -1) return memo[row][idx];

         int down = recurse(row+1,idx,triangle,memo);

         int adjacent = recurse(row+1,idx+1,triangle,memo);

         return memo[row][idx] = triangle.get(row).get(idx) + Math.min(down,adjacent);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int[][] memo = new int[r][triangle.get(r-1).size()];
        for(int[] subMemos : memo){
            Arrays.fill(subMemos,-1);
        }
        return recurse(0,0,triangle,memo);
    }

    */

    /*

    // Bottom Up

    public int minimumTotal(List<List<Integer>> triangle) {

        int r = triangle.size();
        int c = triangle.get(r-1).size();

        int[][] dp = new int[r][c];
        
        // Base Case
        for(int j=0;j<c;j++){
            dp[r-1][j] = triangle.get(r-1).get(j);
        }

        for(int i=r-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){

                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);

            }
        }
        
        return dp[0][0];
    }

    */

    // O(col) Space

    public int minimumTotal(List<List<Integer>> triangle) {

        int r = triangle.size();
        int c = triangle.get(r-1).size();

        int[] dp = new int[c];
        
        // Base Case
        for(int j=0;j<c;j++){
            dp[j] = triangle.get(r-1).get(j);
        }

        for(int i=r-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){

                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);

            }
        }
        
        return dp[0];
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(new ArrayList<>(Arrays.asList(2)));
        tri.add(new ArrayList<>(Arrays.asList(3,4)));
        tri.add(new ArrayList<>(Arrays.asList(6,5,7)));
        tri.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(sol.minimumTotal(tri));
    }

}
