package Java_Graphs.Hard;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph_DFS {
    boolean dfs(int vertices, List<List<Integer>> adj, int[] color) {
        for(int v: adj.get(vertices)) {
            if(color[v] == -1) {
                color[v] = 1 - color[vertices];
                if(!dfs(v, adj, color))
                    return false;
            }
            if(color[v] == color[vertices]) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, List<List<Integer>> adj) {

        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i < V; i++) {

            if(color[i] == -1) {
                if(!dfs(i, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
