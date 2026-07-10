package dsaRepetition.July_10;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class NetworkDelayTime {
    class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] bestTime = new int[n+1];
        
        for(int i=0;i<bestTime.length;i++){
            if(i==k) { 
                bestTime[k] = 0; // network signal starts node always has time 0
                continue;
            }
            bestTime[i] = Integer.MAX_VALUE;
        }

        Map<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] pair : times){

           int u = pair[0];

           int v = pair[1];

           int time = pair[2];

           int[] v_time = {v,time};

           graph.computeIfAbsent(u,temp->new ArrayList<>()).add(v_time);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int u = curr[0];

            if(curr[1] > bestTime[u]) continue;

            if(graph.containsKey(u)){

              for(int[] pair : graph.get(u)){
                
                int v = pair[0];
                int time = pair[1];

                // best time updatation for curent path
                int currCost = bestTime[u]+time;
                if(bestTime[v] > currCost){
                    bestTime[v] = currCost;
                    pq.add(new int[]{v,currCost});
                }

              }

            }

        }

        int minTime = Integer.MIN_VALUE;

        for(int i=1;i<bestTime.length;i++){
            if(bestTime[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime,bestTime[i]);
        }

        return minTime;
    }
    }
}
