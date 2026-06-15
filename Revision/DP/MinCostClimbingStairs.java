package Revision.DP;

import java.util.Arrays;

public class MinCostClimbingStairs {
     static class Solution {

    /*
    // recursive approach

    public int recurse(int[] cost,int idx){

        if(idx >=  cost.length) return 0;

        int start_zero = recurse(cost,idx+1);

        int start_one = recurse(cost,idx+2);

        return cost[idx] + Math.min(start_zero , start_one);

    }
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(recurse(cost,0),recurse(cost,1));
    }

    */


    /*
     // Memo
     
     public int recurse(int[] cost,int idx,int[] dp){

        if(idx >=  cost.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int start_zero = recurse(cost,idx+1,dp);

        int start_one = recurse(cost,idx+2,dp);

        return dp[idx] = cost[idx] + Math.min(start_zero , start_one);

    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(recurse(cost,0,dp),recurse(cost,1,dp));
    }
    */

  
    // Bottom Up
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+2];
        
        for(int i=cost.length-1;i>=0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(sol.minCostClimbingStairs(nums));
    }
}
