package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_I_DFS {
    boolean dfs(int u, List<List<Integer>> adj, boolean[] pathVisited, boolean[] isVisited) {
        pathVisited[u] = true;
        isVisited[u] = true;
        for(int v: adj.get(u)) {
            if(pathVisited[v]) {
                return false;
            }
            if(!isVisited[v] && !dfs(v, adj, pathVisited, isVisited)) {
                return false;
            }
        }
        pathVisited[u] = false;
        return true;
    }
    public boolean canFinish(int N, int[][] arr) {
        int n = arr.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            adj.get(v).add(u);
        }

        boolean[] pathVisited = new boolean[N];
        boolean[] isVisited = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(!isVisited[i] && !dfs(i, adj, pathVisited, isVisited)) {
                return false;
            }
        }
        return true;
    }
}