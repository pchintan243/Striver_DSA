package Java_Graphs.Medium;
import java.util.ArrayList;
import java.util.List;

public class ConnectedComponent {

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int componentCount = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                componentCount++;
                dfs(i, adj, visited);
            }
        }

        return componentCount;
    }
}
