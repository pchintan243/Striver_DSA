package Java_Graphs.Hard;

import java.util.List;

public class DetectCycleDirectedGraph_DFS {
    boolean dfs(int v, List<List<Integer>> adj, boolean[] isVisited, boolean[] pathVisited) {
        isVisited[v] = true;
        pathVisited[v] = true;
        for(int i: adj.get(v)) {
            if(pathVisited[i]) {
                return true;
            }
            if(!isVisited[i] && dfs(i, adj, isVisited, pathVisited)) {
                return true;
            }
        }
        pathVisited[v] = false;

        return false;
    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] isVisited = new boolean[N];
        boolean[] pathVisited = new boolean[N];

        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                if(dfs(i, adj, isVisited, pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
