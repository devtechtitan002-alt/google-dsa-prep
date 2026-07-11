package Algorithms.July_11;

public class PrefixSum {
    public void prefixSum(int[] nums){

        int prefix = 0;

        for(int i=1;i<nums.length;i++){
            nums[i] = prefix + nums[i];
            prefix = nums[i];
        }

    }
}
