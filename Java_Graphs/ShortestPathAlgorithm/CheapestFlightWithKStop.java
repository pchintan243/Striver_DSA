package Java_Graphs.ShortestPathAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithKStop {
  public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
    if(src == dst) {
        return 0;
    }
    int len = flights.length;
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }

    for (int[] data : flights) {
        adj.get(data[0]).add(new int[] {data[1], data[2]});
    }
    Queue<int[]> pq = new LinkedList<>();
    pq.offer(new int[] {0, src, 0});

    int[] cost = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);
    cost[src] = 0;

    while(!pq.isEmpty()) {
        int[] val = pq.poll();
        int dist = val[0];
        int u = val[1];
        int weight = val[2];
        if(dist > K) continue;
        for(int[] data: adj.get(u)) {
            int v = data[0];
            int charge = data[1];
            if(cost[v] > charge + weight && dist <= K) {
                cost[v] = charge + weight;
                pq.offer(new int[]{dist + 1, v, cost[v]});
            }
        }

    }

    return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
  }
}
