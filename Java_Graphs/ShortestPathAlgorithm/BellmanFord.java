package Java_Graphs.ShortestPathAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        final int max = (int) 1e9;
        int[] weight = new int[V];
        Arrays.fill(weight, max);
        weight[S] = 0;
        int n = edges.size();
        for(int i = 0; i < V - 1; i++) {
            for(ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);

                if(weight[u] != max && weight[v] > weight[u] + w) {
                    weight[v] = weight[u] + w;
                }
            }
        }

        // Check for there is negative cycle or not
        for(ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            
            if(weight[u] != max && 
               weight[u] + wt < weight[v]) {
                return new int[]{-1};
            }
        }

        return weight;
    }
}


// Time Complexity:O(V*E) because the outer loop runs V-1 times and the inner loop iterates through all edges E. The negative cycle detection loop also runs through all edges E, but this does not change overall time complexity.
// Space Complexity:O(V) because we use an array of size V to store the weights.