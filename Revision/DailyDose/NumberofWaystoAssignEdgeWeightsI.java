package Revision.DailyDose;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class NumberofWaystoAssignEdgeWeightsI {
    static class Solution {
        public int assignEdgeWeights(int[][] edges) {

    if (edges.length == 0) {
        return 0; // keep your current behavior
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int[] arr : edges) {
        map.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(arr[1]);
        map.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(1);

    Set<Integer> visited = new HashSet<>();
    visited.add(1);

    int depth = 0;

    while (!q.isEmpty()) {

        int level = q.size();

        for (int i = 0; i < level; i++) {

            int curr = q.poll();

            if (map.get(curr) != null) {
                for (int child : map.get(curr)) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        q.add(child);
                    }
                }
            }
        }

        depth++;
    }

    int edgesCount = depth - 1;

    long MOD = 1_000_000_007L;
    long result = 1;
    long base = 2;
    int exp = edgesCount - 1;

    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * base) % MOD;
        }
        base = (base * base) % MOD;
        exp >>= 1;
    }

    return (int) result;
}
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] edges = {
            {1,2},
            {1,3},
            {3,4},
            {3,5}
        };
        System.out.println(sol.assignEdgeWeights(edges));
    }
}
