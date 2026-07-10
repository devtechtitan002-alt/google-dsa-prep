package dsaRepetition.July_8;

public class RunningSumof1dArray {
    class Solution {
    public int[] runningSum(int[] nums) {

        for(int i=1;i<nums.length;i++){
           nums[i] += nums[i-1];
        }

        return nums;
    }
    }
}
