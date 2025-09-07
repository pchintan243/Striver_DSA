package Java_Graphs.ShortestPathAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfArriveDestination {
    public int countPaths(int n, List<List<Integer>> roads) {
        final int MOD = (int) 1e9 + 7;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> data: roads) {
            int u = data.get(0);
            int v = data.get(1);
            int w = data.get(2);
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        int ans = 0;
        long[] weights = new long[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        while(!pq.isEmpty()) {
            long[] val = pq.poll();
            long weight = val[0];
            int u = (int) val[1];
            if(weight > weights[u]) continue;
            
            for(int[] data: adj.get(u)) {
                int v = data[0];
                int w = data[1];
                long wei = weight + w;
                if(wei < weights[v]) {
                    weights[v] = wei;
                    ways[v] = ways[u];
                    pq.offer(new long[]{wei, v});
                } else if(weights[v] == wei) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}


// Time Complexity:O(E log V) where E is the number of roads and V is the number of cities due to Dijkstra's algorithm.
// Space Complexity:O(V + E) where V is the number of cities for storing weights and ways, and E is the number of roads for the adjacency list.