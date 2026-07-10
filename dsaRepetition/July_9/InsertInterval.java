package dsaRepetition.July_9;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    static class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        
        List<int[]> result = new ArrayList<>();
        
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;

        for(int[] interval : intervals){
            min = Math.min(interval[0],min);
            max = Math.max(interval[0],max);
        }

        // for include new Also
        min = Math.min(newInterval[0],min);
        max = Math.max(newInterval[0],max);

        int[] range = new int[max - min + 1];

        for(int[] interval : intervals){
            int idx = interval[0]-min;
            int farthest = interval[1]-min;
            range[idx] = Math.max(range[idx],farthest);
        }

        range[newInterval[0]-min] = Math.max(range[newInterval[0]-min],newInterval[1]-min);

        int start=0,end=0;

        for(int i=0;i<range.length;i++){

            if(range[i] == 0) continue;

            if(i<=end){
                end = Math.max(range[i],end);
            }else{
                result.add(new int[]{start+min,end+min});
                start = i;
                end = range[i];
            }
        }

        result.add(new int[]{start+min,end+min});
        return result.toArray(new int[0][]);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] inter = {
           {1,2},{3,5},{6,7},{8,10},{12,16}
        };
        for(int[] ans : sol.insert(inter,new int[]{4,8})){
            System.out.println(Arrays.toString(ans));
        }
    }

    // Another apparoach

    /*
    class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0)
            return new int[][] {newInterval};
        List<int[]> list = new ArrayList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0])
        {
            list.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1])
        {
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while(i<intervals.length)
        {
            list.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[0][]);
    }
} */
}
