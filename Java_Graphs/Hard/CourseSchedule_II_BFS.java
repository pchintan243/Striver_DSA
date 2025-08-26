package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_II_BFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int ind = 0;
        int[] ans = new int[numCourses];

        while(!q.isEmpty()) {
            int u = q.poll();
            ans[ind++] = u;
            for(int v: adj.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if(ind == numCourses) {
            return ans;
        }
        return new int[]{};

        
    }
}