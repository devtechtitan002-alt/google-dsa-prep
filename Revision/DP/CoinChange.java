package Revision.DP;
import java.util.Arrays;

public class CoinChange {
    static class Solution {

    /*

    // recursion

    public int recurse(int target, int[] coins) {

        if (target == 0) {
            return 0;
        }

        if (target < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {

            int res = recurse(target - coin, coins);

            if (res != -1) {
                min = Math.min(min, res + 1);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int coinChange(int[] coins, int amount) {
        return recurse(amount, coins);
    }

    */


    /*

    // Memo

     public int recurse(int target, int[] coins,Integer[] memo) {

        if (target == 0) {
            return 0;
        }

        if (target < 0) {
            return -1;
        }

        if(memo[target]!=null) return memo[target];

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {

            int res = recurse(target - coin, coins,memo);

            if (res != -1) {
                min = Math.min(min, res + 1);
            }
        }

        return memo[target] = (min == Integer.MAX_VALUE ? -1 : min);
    }

    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount+1];
        return recurse(amount, coins,memo);
    }

    */

    // Bottom Up

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];

        Arrays.fill(dp,-1);

        // Base case  - 0 coins needed to make 0
        dp[0]=0;

        for(int i=1;i<dp.length;i++){  // As base case when target==0 so start from 1 is enough

            int min = Integer.MAX_VALUE;

            for(int coin : coins){

                int sum = i - coin;

                if(sum >= 0 && dp[sum]!=-1){
                    min = Math.min(min,dp[sum]+1); 
                }

            }

            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }


        return dp[amount];
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5},10));
    }


    /*
     public static int recurse(int idx, int target, int[] coins, int[] counter, int[][] memo) {

        if (target == 0) {
            counter[1] = Math.min(counter[0], counter[1]);
            return counter[1];
        }

        if (target < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < coins.length; i++) {
            counter[0] += 1;
            int value = recurse(i, target - coins[i], coins, counter, memo);
            if (value != -1) {
                min = Math.min(min, value);
            }
            counter[0] -= 1;
        }

        return min == Integer.MAX_VALUE ? counter[1] : min;
    }

    public static int coinChange(int[] coins, int amount) {
        int[] totalVsMin = new int[2];
        totalVsMin[1] = Integer.MAX_VALUE;
        int[][] memo = new int[coins.length][amount + 1];
        int ans = recurse(0, amount, coins, totalVsMin, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
         */

    /*
    public int recurse(int idx, int target, int[] coins, int[] counter, int[][] memo) {

        if (target == 0) {
            counter[1] = Math.min(counter[0], counter[1]);
            return  counter[1];
        }

        if (target < 0) {
            return  -1;
        }

        if( memo[idx][target]  != -1) return  memo[idx][target];

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < coins.length; i++) {
            counter[0] += 1;
            int value = recurse(i, target - coins[i], coins, counter, memo);
            if (value != -1) {
                min = Math.min(min, value);
            }
            counter[0] -= 1;
        }

        return memo[idx][target] = min == Integer.MAX_VALUE ? counter[1] : min;
    }

    public int coinChange(int[] coins, int amount) {
        int[] totalVsMin = new int[2];
        totalVsMin[1] = Integer.MAX_VALUE;
        int[][] memo = new int[coins.length][amount + 1];
        for(int[] dps : memo){
            Arrays.fill(dps,-1);
        }
        int ans = recurse(0, amount, coins, totalVsMin, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    } */
}
