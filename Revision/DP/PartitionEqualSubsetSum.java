package Revision.DP;
import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static class Solution {

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
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = new int[]{1,2,3,5};
        System.out.println(sol.canPartition(nums));
    }
}
