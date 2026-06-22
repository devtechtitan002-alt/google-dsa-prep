package Revision.Contests;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class P2 {
    static class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] edge : edges){
            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(i)) stack.add(i);
        }

        while(!stack.isEmpty()){
            
            int edge = stack.pop();

            int temp = 0;

            if(map.containsKey(edge)){

                int e=Integer.MAX_VALUE,l=Integer.MIN_VALUE;

                for(int child : map.get(edge)){
                    int bT = baseTime[child];
                    e = Math.min(e,bT);
                    l = Math.max(l,bT);  
                }

                int own = (l-e) +  baseTime[edge];

                temp = l + own;

            }

            baseTime[edge] = temp;

        }

        return baseTime[0];
    }
    }

    public static void main(String[] s){
        Solution sol = new Solution();
        int[][] edge = {{0,1},{0,2},{0,3}};
        System.out.println(sol.finishTime(3,edge,new int[]{9,10,6,8}));
    }
}
