package dsaRepetition.July_10;
import java.util.Arrays;

public class NonoverlappingIntervals {
    static class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int removal = 0;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int[] prev = intervals[0];

        for(int i=1;i<intervals.length;i++){
           
            int[] curr = intervals[i];

            if(curr[0] < prev[1]){
                removal++;
                if(prev[1] > curr[1]){
                   prev = curr;
                }
            }else{
                prev = curr;
            }
        }

        return removal;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
    }

    // another appraoch

    /*
    class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }
        int shift = 1 - min;
        int[] rightEnds = new int[max - min + 2];
        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (rightEnds[right] < left) rightEnds[right] = left;
        }
        int count = 0;
        int start = 0;
        for (int i = 1; i < rightEnds.length; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }
        return intervals.length - count;
    }
}
     */
}
