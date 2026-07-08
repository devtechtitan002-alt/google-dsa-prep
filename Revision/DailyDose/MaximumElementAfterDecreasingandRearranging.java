package Revision.DailyDose;
import java.util.Arrays;

public class MaximumElementAfterDecreasingandRearranging {
     static class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        int prev = 0;  // should  starts with 1

        for(int num : arr){

            if(prev == num) continue;

            prev = Math.min(num , prev+1);   // each adjacent element should have diff <= 1
        }

        return prev;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,10000}));
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}
