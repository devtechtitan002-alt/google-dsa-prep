package Algorithms.July_11;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public void dijkstra(int[][] edges,int n){

        int[] distance = new int[n];
Arrays.fill(distance, Integer.MAX_VALUE);

distance[0] = 0;

Map<Integer, List<int[]>> graph = new HashMap<>();

for (int[] edge : edges) {
    int u = edge[0];
    int v = edge[1];
    int w = edge[2];

    graph.computeIfAbsent(u, k -> new ArrayList<>())
         .add(new int[]{v, w});
}

PriorityQueue<int[]> pq =
    new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

pq.add(new int[]{0, 0});

while (!pq.isEmpty()) {

    int[] curr = pq.poll();

    int u = curr[0];
    int d = curr[1];

    if (d > distance[u])
        continue;

    if (!graph.containsKey(u))
        continue;

    for (int[] neighbor : graph.get(u)) {

        int v = neighbor[0];
        int w = neighbor[1];

        if (distance[u] + w < distance[v]) {

            distance[v] = distance[u] + w;

            pq.add(new int[]{v, distance[v]});
        }
    }
}

    }
}
