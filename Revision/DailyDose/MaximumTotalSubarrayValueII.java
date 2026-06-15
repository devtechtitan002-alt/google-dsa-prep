package Revision.DailyDose;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class MaximumTotalSubarrayValueII {
    static class Solution {

    public long maxTotalValue(int[] nums, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->Long.compare(a,b));

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            int min = i;
            int max = i;

            for(int j=i;j<nums.length;j++){

                list.add(nums[j]);

                 min = nums[min] > nums[j] ? j : min;
                 max = nums[max] < nums[j] ? j : max;

                // System.out.println(list +"_____" + "max:"+max+ "------" + "min:"+min);

                pq.add((long)nums[max]-nums[min]);

                if(pq.size() > k){
                   pq.poll();
                }

            }

            // list = new ArrayList<>();

        }

        long result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }

        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxTotalValue(new int[]{11,8},2));
    }
}
