package dsaRepetition.July_9;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MergeIntervals {
    static class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> answer = new ArrayList<>();

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        answer.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            
            int[] lastMerged = answer.get(answer.size() - 1);            
            int[] curr = intervals[i];

            if(curr[0] <= lastMerged[1]){
                lastMerged[1] =  Math.max(lastMerged[1], curr[1]);
            }else{
                answer.add(curr);
            }

        }

        return answer.toArray(new int[0][]);

    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] inter = {
           {4,7},{1,4}
        };
        for(int[] ans : sol.merge(inter)){
            System.out.println(Arrays.toString(ans));
        }
    }
}
