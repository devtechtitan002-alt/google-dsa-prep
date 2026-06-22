package Revision.DailyDose;

public class FindtheHighestAltitude {
    static class Solution {
    public int largestAltitude(int[] gain) {
        int highAlt = 0,maxAlt=0;

        for(int num : gain){
           highAlt += num;
           maxAlt = Math.max(maxAlt,highAlt);
        }

        return maxAlt;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(sol.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
}
