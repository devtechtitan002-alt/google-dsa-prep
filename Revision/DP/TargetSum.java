package Revision.DP;
import java.util.Arrays;

public class TargetSum {
    static class Solution {
    
    /* 
    // Recursion

    public int recurse(int idx,int sum,int[] nums,int target){

        if(idx == nums.length) return sum == target ? 1 : 0;
        return recurse(idx+1,sum+nums[idx],nums,target) + recurse(idx+1,sum-nums[idx],nums,target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return recurse(0,0,nums,target);
    }

    */

    /*
    // Memo

    public int recurse(int idx,int sum,int[] nums,int target,int[][] memo,int offset){

        if(idx == nums.length) return sum == target ? 1 : 0;
        if(memo[idx][sum+offset]!=-1) return memo[idx][sum+offset];
        return memo[idx][sum+offset] = recurse(idx+1,sum+nums[idx],nums,target,memo,offset) + recurse(idx+1,sum-nums[idx],nums,target,memo,offset);

    }

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        int offset = sum;
        int[][] memo = new int[nums.length][2*(sum+1)];

        for(int[] subMemos : memo){
            Arrays.fill(subMemos,-1);
        }

        return recurse(0,0,nums,target,memo,offset);
    }

    */

    // Bottom Up

    public int findTargetSumWays(int[] nums, int target) {

    int sum = 0;
    for (int num : nums) {
        sum += num;
    }

    if (Math.abs(target) > sum) {
        return 0;
    }

    int offset = sum;
    int[][] dp = new int[nums.length + 1][2 * sum + 1];

    // Base case:
    // When no elements remain, there is 1 way iff current sum == target
    dp[nums.length][target + offset] = 1;

    for (int i = nums.length - 1; i >= 0; i--) {

        for (int j = 0; j < dp[0].length; j++) {

            int sumValue = j - offset;

            int plusSum = sumValue + nums[i];
            int minusSum = sumValue - nums[i];

            if (plusSum >= -offset && plusSum <= offset) {
                dp[i][j] += dp[i + 1][plusSum + offset];
            }

            if (minusSum >= -offset && minusSum <= offset) {
                dp[i][j] += dp[i + 1][minusSum + offset];
            }
        }
    }

    // Start from index 0 with current accumulated sum = 0
    return dp[0][offset];
}
    
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,1,1};
        System.out.println(sol.findTargetSumWays(nums,1));
    }
}
