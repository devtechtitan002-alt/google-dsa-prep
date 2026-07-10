package dsaRepetition.July_10;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class CourseScheduleII {
    class Solution{
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            Map<Integer,List<Integer>> graph = new HashMap<>();
            Map<Integer,Integer> indegree = new HashMap<>();

            // assign all indegrees to 0
            for(int i=0;i<numCourses;i++){
                indegree.putIfAbsent(i,0);
            }

            // build graph
            for(int[] course : prerequisites){
                graph.computeIfAbsent(course[1],k->new ArrayList<>()).add(course[0]);
                indegree.put(course[0],indegree.get(course[0])+1);
            }

            Queue<Integer> root = new ArrayDeque<>();
            List<Integer> order = new ArrayList<>();

            for(Map.Entry<Integer,Integer> entry : indegree.entrySet()){
               if(entry.getValue() == 0) root.add(entry.getKey());
            }

            while(!root.isEmpty()){
                 
                int curr = root.poll();
                order.add(curr);

                if(graph.containsKey(curr)){
                    for(int course : graph.get(curr)){
                        indegree.put(course,indegree.get(course)-1);
                        if(indegree.get(course) == 0){
                            root.offer(course);
                        }
                    }
                }
            }

            // cycle detection
            if(order.size() != numCourses) return new int[]{};

            int[] array = new int[order.size()];
            for (int i = 0; i < order.size(); i++) {
              array[i] = order.get(i);
            }

            return array;
        }
    }
}
