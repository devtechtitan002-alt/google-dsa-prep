package Revision.DP;

public class TargetSum {
    static class Solution {
    
    public int recurse(int idx,int sum,int[] nums,int target){

        if(idx == nums.length && sum == target) return 1;
        
        if(idx >= nums.length) return 0;

        return recurse(idx+1,sum+nums[idx],nums,target) + recurse(idx+1,sum-nums[idx],nums,target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return recurse(0,0,nums,target);
    }
    
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,1,1,1,1};
        System.out.println(sol.findTargetSumWays(nums,3));
    }
}
