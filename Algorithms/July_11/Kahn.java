package Algorithms.July_11;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Kahn {
    public boolean kahn(int[][] prerequisites,int n){

        Map<Integer,List<Integer>> graph = new HashMap<>(); 
        int[] indegree = new int[n];   // indegree 

        // build graph
        for(int[] course : prerequisites){
            graph.computeIfAbsent(course[1],k->new ArrayList<>()).add(course[0]);
            indegree[course[0]]++;
        }

        Queue<Integer> root = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        for(int i=0;i<indegree.length; i++){
            if(indegree[i] == 0) root.add(i);
        }

        while(!root.isEmpty()){

            int u = root.poll();
            order.add(u);

            if(graph.containsKey(u)){
                for(int v : graph.get(u)){
                   indegree[v]--;
                   if(indegree[v] == 0){
                      root.offer(v);
                   }
                }
            }
        }

        // cycle detection
        if(order.size() != n) return false;

        return true;
    }
}
