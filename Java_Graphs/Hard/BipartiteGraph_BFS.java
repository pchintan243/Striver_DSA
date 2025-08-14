package Java_Graphs.Hard;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph_BFS {
    public boolean isBipartite(int V, List<List<Integer>> adj) {

        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;

                while(!q.isEmpty()) {
                    int vertices = q.poll();
                    for(int v: adj.get(vertices)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[vertices];
                            q.offer(v);
                        } 
                        // If neighbor is already colored, check if it's the same color as the current node
                        else if (color[v] == color[vertices]) {
                            return false; // Found an odd-length cycle
                        }
                    }
                }
            }
        }
        return true;
    }
}
