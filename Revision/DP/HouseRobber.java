package Revision.DP;
import java.util.Arrays;

public class HouseRobber {
    static class Solution{

        /*
        // Recursive version

        public int recurse(int idx,int[] nums){

            if(idx >= nums.length) return 0;

            int take = recurse(idx+2,nums);

            int skip = recurse(idx+1,nums);

           return Math.max(nums[idx]+take,skip);

        }

        public int rob(int[] nums) {
            return recurse(0,nums);
        }

        */


        /*
        // Memo 

        public int recurse(int idx,int[] nums,int[] memo){

            if(idx >= nums.length) return 0;

            if(memo[idx] != -1) return memo[idx];

            int take = recurse(idx+2,nums,memo);

            int skip = recurse(idx+1,nums,memo);

           return memo[idx] = Math.max(take+nums[idx],skip);

        }

        public int rob(int[] nums) {
            int[] memo = new int[nums.length];
            Arrays.fill(memo,-1);
            return recurse(0,nums,memo);
        }

        */


        /*
        // Bottom Up

        public int rob(int[] nums) {

            int[] dp = new int[nums.length+2];

            for(int i=nums.length-1;i>=0;i--){
                int take = nums[i]+dp[i+2];
                int skip = dp[i+1];
                dp[i] = Math.max(take,skip);
            }

            return dp[0];
        }
        */


        // O(1) Space

        public int rob(int[] nums) {


            int house1=0,house2=0,currHouse=0;

            for(int i=nums.length-1;i>=0;i--){

                int take = nums[i]+house2;
                int skip = house1;
                currHouse = Math.max(take,skip);

                int temp = house1;
                house1 = currHouse;
                house2 = temp;

            }

            return house1;
        }
        

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{100,1,1,100}));
    }
}
