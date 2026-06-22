package Revision.DP;
import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static class Solution {

        /*
        
        // recursion
        
        public boolean recurse(int idx,int target,int[] nums){

        if( target == 0 ) return true;

        if(idx >= nums.length) return false;

        if(target < 0) return false;

        boolean take = recurse(idx+1,target-nums[idx],nums);

        boolean skip = recurse(idx+1,target,nums);

        return take || skip;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0) return false;

        return recurse(0,sum/2,nums);
    }

    */

    /*
     
    // Memo

    public boolean recurse(int idx,int target,int[] nums,Boolean[][] memo){

        if( target == 0 ) return true;

        if(idx >= nums.length) return false;

        if(target < 0) return false;

        if(memo[idx][target]!=null) return memo[idx][target];

        boolean take = recurse(idx+1,target-nums[idx],nums,memo);

        boolean skip = recurse(idx+1,target,nums,memo);

        return memo[idx][target] = take || skip;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0) return false;

        Boolean[][] memo = new Boolean[nums.length][(sum/2)+1];

        return recurse(0,sum/2,nums,memo);
    }

    */

    // Bottom Up


    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0) return false;

        boolean[][] dp = new boolean[nums.length+1][(sum/2)+1];

        for(int i=0;i<=nums.length;i++){
            dp[i][0] = true;
        }

        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<dp[0].length;j++){

                boolean take = (j-nums[i] < 0) ? false : dp[i+1][j-nums[i]];

                boolean skip = dp[i+1][j];

                dp[i][j] =  take || skip;
            }
        }


        return dp[0][sum/2];
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = new int[]{1,2,3,5};
        System.out.println(sol.canPartition(nums));
    }
}
