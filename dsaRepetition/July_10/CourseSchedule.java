package dsaRepetition.July_10;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CourseSchedule {
    class Solution{

        public boolean dfs(int course,Map<Integer,List<Integer>> graph,boolean[] visited,boolean[] visiting){
             
             // already complted course from current
            if(visited[course]) return true;

            // loop detection
            if(visiting[course]) return false;

            visiting[course] = true;

            if(graph.containsKey(course)){
            for(int courses : graph.get(course)){
                if(!dfs(courses,graph,visited,visiting)) return false;
            }
            }

            visiting[course] = false;
            visited[course] = true;

            return true;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {

           Map<Integer,List<Integer>> graph = new HashMap<>();

           for(int[] course : prerequisites){
              graph.computeIfAbsent(course[0],k->new ArrayList<>()).add(course[1]);
           }

           boolean[] visited  = new boolean[numCourses];
           boolean[] visiting = new boolean[numCourses];

           for(int key=0;key<numCourses;key++){
            if(!visited[key]){
               if(!dfs(key,graph,visited,visiting)) return false;
            }
           }

           return true;
        }
    }
}
