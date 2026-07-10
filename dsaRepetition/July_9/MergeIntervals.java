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

    // optimization
    /*
    class Solution {
    public int[][] merge(int[][] intervals) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < intervals.length; i++) {
			min = Math.min(min, intervals[i][0]);
			max = Math.max(max, intervals[i][0]);
		}
		
		int[] range = new int[max - min + 1];
		for (int i = 0; i < intervals.length; i++) {
			range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]); 
		}
		
		int start = 0, end = 0;
		LinkedList<int[]> result = new LinkedList<>();
		for (int i = 0; i < range.length; i++) {
			if (range[i] == 0) {
				continue;
			}
			if (i <= end) {
				end = Math.max(range[i], end);
			} else {
				result.add(new int[] {start + min, end + min});
				start = i;
				end = range[i];
			}
		}
		result.add(new int[] {start + min, end + min});
		return result.toArray(new int[result.size()][]);
	}
}
     */
}
