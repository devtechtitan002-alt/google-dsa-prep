package Revision.Math;

public class WaterBottles {
    static class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

    int ans = numBottles;

    while (numBottles >= numExchange) {

        int q = numBottles / numExchange;
        int rem = numBottles % numExchange;

        ans += q;

        numBottles = q + rem;
    }

    return ans;
}
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numWaterBottles(9,3));
    }
}
