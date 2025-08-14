package Java_Graphs.Hard;
import java.util.List;

public class DetectCycleUndirectedGraph_DFS {
    boolean dfs(int vertices, List<Integer>[] adj, boolean[] isVisited, int cameFrom) {
        isVisited[vertices] = true;

        for(Integer v: adj[vertices]) {
            // If not visited then mark it as visited
            if(!isVisited[v]) {
                isVisited[v] = true;
                if(dfs(v, adj, isVisited, vertices))
                    return true;
            } else if(v != cameFrom){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] isVisited = new boolean[V];
        for(int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) {
                boolean isCycle = dfs(i, adj, isVisited, -1);
                if(isCycle) {
                    return true;
                }
            }
        }
        return false;
    }
}
