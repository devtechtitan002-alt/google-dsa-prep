package Revision.DailyDose;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class NetworkRecoveryPathways {

    record State3D(int index, int cost, Long constraint) {}

    static class Solution {

    private Map<State3D, Integer> memo;

    class Pair{
        int destinyVertex;
        int cost;

        Pair(int destinyVertex,int cost){
            this.destinyVertex = destinyVertex;
            this.cost = cost;
        }

    }

    // Memo

    public int dfsMemo(Map<Integer,List<Pair>> map,boolean[] online,int vertex,int score,long pathSum,Map<State3D,Integer> memo){

        if(vertex == 0){
            if(pathSum >= 0){  // only update valid path if pathSum <= k
                return score;
            }
            return -1;  // invalid path as pathSum > k
        }

        // valid path not contains online - false so return without update answer || invalid paths so return -1
        if(!online[vertex] || pathSum < 0) return -1; 

        List<Pair> pairList = map.containsKey(vertex) ? map.get(vertex) : new ArrayList<>();

        int answer = -1;

        for(Pair pairs : pairList){
            int nextVertex = pairs.destinyVertex;
            int nextCost = pairs.cost;
            int tempScore = dfsMemo(map,online,nextVertex,Math.min(score,nextCost),pathSum-nextCost,memo);
            answer = Math.max(answer,tempScore);
        }

        return answer;
    }

    public int findMaxPathScoreMemo(int[][] edges, boolean[] online, long k) {

        Map<Integer,List<Pair>> map = new HashMap<>();

        memo = new HashMap<>();

        for(int[] edge : edges){
            int vertex = edge[1];
            Pair pair = new Pair(edge[0],edge[2]);
            map.computeIfAbsent(vertex,list -> new ArrayList<Pair>()).add(pair);
        }

        return dfsMemo(map,online,online.length-1,Integer.MAX_VALUE,k,memo);
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] edges = {
           {0,1,7},{1,4,5},{0,2,6},{2,3,6},{3,4,2},{2,4,6}
        };

        int[][] edges1 = {
           {0,1,7},{0,2,8},{1,3,10},{2,3,5},{3,4,6}
        };

        boolean[] online = {true,true,true,false,true};


        boolean[] online1 = {true,true,true,true,true};

        int k = 12;

        int k1 = 25;

        System.out.println(sol.findMaxPathScoreMemo(edges1,online1,k1));
    }

    /*
    public int dfsMemo(Map<Integer,List<Pair>> map,boolean[] online,int vertex,int score,long pathSum,int totalVertices){

        if(vertex == totalVertices-1){
            if(pathSum >= 0){  // only update valid path if pathSum <= k
                return score;
            }
            return -1;  // invalid path as pathSum > k
        }

        // valid path not contains online - false so return without update answer
        if(!online[vertex]) return -1;

        List<Pair> pairList = map.containsKey(vertex) ? map.get(vertex) : new ArrayList<>();

        int answer = -1;

        for(Pair pairs : pairList){
            int nextVertex = pairs.destinyVertex;
            int nextCost = pairs.cost;
            int tempScore = dfsMemo(map,online,nextVertex,Math.min(score,nextCost),pathSum-nextCost,totalVertices);
            answer = Math.max(answer,tempScore);
        }

        return answer;
    }

    public int findMaxPathScoreMemo(int[][] edges, boolean[] online, long k) {

        Map<Integer,List<Pair>> map = new HashMap<>();

        for(int[] edge : edges){
            int vertex = edge[0];
            Pair pair = new Pair(edge[1],edge[2]);
            map.computeIfAbsent(vertex,list-> new ArrayList<Pair>()).add(pair);
        }

        return dfsMemo(map,online,0,Integer.MAX_VALUE,k,online.length);
    } */

        /*
    // recursion

    public int dfs(Map<Integer,List<Pair>> map,boolean[] online,int vertex,int cost,int minSoFar,long pathSum,int totalVertices){

        if(vertex == totalVertices-1){
            if(pathSum >= 0){  // only update valid path if pathSum <= k
                return Math.min(minSoFar,cost);
            }
            return -1;  // invalid path as pathsSum > k
        }

        // valid path not contains online - false so return without update answer
        if(!online[vertex]) return -1;

        List<Pair> pairList = map.containsKey(vertex) ? map.get(vertex) : new ArrayList<>();

        int mins = -1;

        for(Pair pairs : pairList){
            int nextVertex = pairs.destinyVertex;
            int nextCost = pairs.cost;
            int min = dfs(map,online,nextVertex,nextCost,Math.min(minSoFar,nextCost),pathSum-nextCost,totalVertices);
            mins = Math.max(mins,min);
        }

        return mins;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        Map<Integer,List<Pair>> map = new HashMap<>();

        for(int[] edge : edges){
            int vertex = edge[0];
            Pair pair = new Pair(edge[1],edge[2]);
            map.computeIfAbsent(vertex,list-> new ArrayList<Pair>()).add(pair);
        }

        return dfs(map,online,0,Integer.MAX_VALUE,Integer.MAX_VALUE,k,online.length);
    }

    */

}
