package Revision.DailyDose;
import java.util.Arrays;

public class RemoveCoveredIntervals {
     static class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        // we need to sort in descending order
        Arrays.sort(intervals,(a,b)-> (a[0] != b[0]) ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]) );

        int count = 1;

        for(int i=1;i<intervals.length;i++){

            int a = intervals[i-1][0];
            int b = intervals[i-1][1];   // [a,b)

            int c = intervals[i][0];
            int d = intervals[i][1];     // [c,d)

            boolean leftBoundary = ( a == c ) ? true : c<=a;

            boolean rightBoundary = ( a == c ) ? d<=b: b<=d;

            boolean isCovered = leftBoundary && rightBoundary;

            if(!isCovered){
               count ++;
            } 

        }

        return count;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] intervals = {
            {1,4},{2,3}
        };
        System.out.println(sol.removeCoveredIntervals(intervals));
    }
}
