import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Iterator;
class TopKFrequentElements{
    static class Solution{
        public int[] topKFrequent(int[] nums,int k){
            HashMap<Integer,Integer> freqMap = new HashMap<>();
            for(int num : nums){
               freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->freqMap.get(a)-freqMap.get(b));
            for(int key : freqMap.keySet()){
               pq.add(key);
               if(pq.size()>k){ pq.poll();}
            }
            int[] result = new int[k];
            int i = 0;
            while (!pq.isEmpty()) {
             result[i++] = pq.poll();
            }
            return result;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.topKFrequent(new int[]{1,1,1,2,2,3},2));
        System.out.println(sol.topKFrequent(new int[]{1},1));
        System.out.println(sol.topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2},2));
    }
}