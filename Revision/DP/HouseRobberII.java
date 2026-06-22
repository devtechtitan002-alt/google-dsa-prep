package Revision.DP;

import java.util.Arrays;

public class HouseRobberII {
     static class Solution{


        /*

        // Recursion 

        public int recurse(int[] nums,int idx,int e){

        if(idx >= e) return 0;
        
        int doRob = recurse(nums,idx+2,e);

        int skipRob = recurse(nums,idx+1,e);

        return Math.max(nums[idx]+doRob , skipRob);

        }

        public int rob(int[] nums) {

         if(nums.length==1) return nums[0];

         int startAtZero  = recurse(nums,0,nums.length-1);

         int startAtFirst = recurse(nums,1,nums.length);

         return Math.max(startAtZero,startAtFirst);

        }

        */


     /* 
     // Memo 

     public int recurse(int[] nums,int idx,int e,int[] dp){

        if(idx >= e) return 0;

        if(dp[idx] != -1) return dp[idx];
        
        int doRob = recurse(nums,idx+2,e,dp);

        int skipRob = recurse(nums,idx+1,e,dp);

        return dp[idx] = Math.max(nums[idx]+doRob , skipRob);

     }
     public int rob(int[] nums) {

         if(nums.length==1) return nums[0];

         int[] dp = new int[nums.length];

         Arrays.fill(dp,-1);
         int startAtZero  = recurse(nums,0,nums.length-1,dp);

         Arrays.fill(dp,-1);
         int startAtFirst = recurse(nums,1,nums.length,dp);

         return Math.max(startAtZero,startAtFirst);

     }

     */


     /*

    // Bottom UP

     public int rob(int[] nums) {

         if(nums.length==1) return nums[0];

         int[] dp_zero = new int[nums.length+1];

         for(int i=nums.length-2;i>=0;i--){

            int take = nums[i] + dp_zero[i+2];
            int skip = dp_zero[i+1];

            dp_zero[i] = Math.max(take,skip);

         }

         int[] dp_one = new int[nums.length+2];

         for(int i=nums.length-1;i>=1;i--){

            int take = nums[i] + dp_one[i+2];
            int skip = dp_one[i+1];

            dp_one[i] = Math.max(take,skip);

         }

        return Math.max(dp_zero[0],dp_one[1]);

     }

     */


     // O(1) Space

     public int rob(int[] nums) {

         if(nums.length==1) return nums[0];


         int house1=0,house2=0,currHouse=0;

         for(int i=nums.length-2;i>=0;i--){

            int take = nums[i] + house2;
            int skip = house1;

            currHouse = Math.max(take,skip);

            int temp = house1;
            house1 = currHouse;
            house2 = temp;

         }

         int house_1=0,house_2=0,curr_House=0;

         for(int i=nums.length-1;i>=1;i--){

            int take = nums[i] + house_2;
            int skip = house_1;

            curr_House = Math.max(take,skip);

            int temp = house_1;
            house_1 = curr_House;
            house_2 = temp;

         }

        return Math.max(house1,house_1);

     }


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{1,2,3,1}));
    }
}
