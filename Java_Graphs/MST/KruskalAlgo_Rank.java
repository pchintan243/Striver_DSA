package Java_Graphs.MST;
import java.util.ArrayList;
import java.util.List;

public class KruskalAlgo_Rank {

    int findParentNode(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = findParentNode(parent[node], parent);
    }
    
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (List<Integer> e : adj.get(u)) {
                int v = e.get(0);
                int w = e.get(1);
                edges.add(new int[]{w, u, v});
            }
        }

        edges.sort(Comparator.comparingInt(o -> o[0]));

        int[] rank = new int[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }
        int sum = 0;
        for(int[] data: edges) {
            int w = data[0];
            int u = data[1];
            int v = data[2];

            int ultParentU = findParentNode(u, parent);
            int ultParentV = findParentNode(v, parent);

            if(ultParentU == ultParentV) {
                continue;
            }
            sum += w;
            if(rank[ultParentU] < rank[ultParentV]) {
                parent[ultParentU] = ultParentV;
            } else if(rank[ultParentU] > rank[ultParentV]) {
                parent[ultParentV] = ultParentU;
            } else {
                rank[ultParentU]++;
                parent[ultParentV] = ultParentU;
            }
        }

        return sum;
    }
}

// Time Complexity:O(E log E + V + E * alpha(V)), where E is the number of edges, V is the number of vertices, and alpha is the inverse Ackermann function.
// Space Complexity:O(V + E), where V is the number of vertices to store rank and parent, and E to store the edges.