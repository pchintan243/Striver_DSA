package Java_Graphs.ShortestPathAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra_PQ {
  public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

    int[] ans = new int[V];
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    pq.offer(new int[]{0, S});
    Arrays.fill(ans, Integer.MAX_VALUE);
    ans[S] = 0;
    while(!pq.isEmpty()) {
        int[] val = pq.poll();
        int u = val[1];
        int distance = val[0];
        for(ArrayList<Integer> data: adj.get(u)) {
            int v = data.get(0);
            int weight = data.get(1);
            if(ans[v] > distance + weight) {
                pq.offer(new int[]{distance + weight, v});
                ans[v] = distance + weight;
            }
        }
    }
    for(int i = 0; i < V; i++) {
        if(ans[i] == Integer.MAX_VALUE) {
            ans[i] = 1000000000;
        }
    }
    return ans;
  }
}


// Time Complexity:O(V + ElogV), where V is the number of vertices and E is the number of edges, due to
// the priority queue operations and graph traversal. Also considering the two for loops, one for initialization and one
// for replacing the Integer.MAX_VALUE
// Space Complexity:O(V), where V is the number of vertices, due to the ans array and priority queue in the worst-case scenario.