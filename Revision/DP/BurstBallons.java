package Revision.DP;
import java.util.Arrays;

public class BurstBallons {
    static class Solution {

        /*
    // recursive approach

    public int burstBallons(int[] nums,int s,int e){
        if(s > e) return 0;

        int coin = 0;

        for(int i=s;i<=e;i++){
            coin = Math.max(coin,(nums[s-1]*nums[i]*nums[e+1] + burstBallons(nums,s,i-1) + burstBallons(nums,i+1,e)));
        }

        return coin;
    }

    public int maxCoins(int[] nums) {
        int[] border = new int[nums.length+2];
        
        for(int i=0;i<border.length;i++){
            if(i==0 || i==nums.length+1) border[i] = 1;
            else border[i] = nums[i-1];
        }

        return burstBallons(border,1,nums.length);
    }

    */

    /*

    // DP Memoization

    public int burstBallonsDP(int[] nums,int s,int e,int[][] memo){
        if(s > e) return 0;

        if(memo[s][e] != -1) return memo[s][e];

        int coin = 0;

        for(int i=s;i<=e;i++){
            coin = Math.max(coin,(nums[s-1]*nums[i]*nums[e+1] + burstBallonsDP(nums,s,i-1,memo) + burstBallonsDP(nums,i+1,e,memo)));
        }

        return memo[s][e] = coin;
    }

    public int maxCoinsDP(int[] nums) {
        int[] border = new int[nums.length+2];
        
        for(int i=0;i<border.length;i++){
            if(i==0 || i==nums.length+1) border[i] = 1;
            else border[i] = nums[i-1];
        }

        int[][] memo = new int[nums.length+1][nums.length+1];

        for(int[] dps : memo){
            Arrays.fill(dps,-1);
        }

        return burstBallonsDP(border,1,nums.length,memo);
    }

    */
   

    // DP Bottom Up

    public int maxCoins(int[] nums) {

    int n = nums.length;

    int[] border = new int[n + 2];
    border[0] = 1;
    border[n + 1] = 1;

    for(int i = 0; i < n; i++) {
        border[i + 1] = nums[i];
    }

    int[][] dp = new int[n + 2][n + 2];

    // length of interval
    for(int len = 1; len <= n; len++) {

        for(int s = 1; s + len - 1 <= n; s++) {

            int e = s + len - 1;

            // choose k as last balloon burst
            for(int k = s; k <= e; k++) {

                int coins =
                    border[s - 1] * border[k] * border[e + 1]
                    + dp[s][k - 1]
                    + dp[k + 1][e];

                dp[s][e] = Math.max(dp[s][e], coins);
            }
        }
    }

    return dp[1][n];
}

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxCoins(new int[]{1,5}));
    }
}
