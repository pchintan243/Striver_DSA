package Java_Graphs.MST;
import java.util.List;

public class PrimsAlgo {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[] isVisited = new boolean[V];
        pq.offer(new int[]{0, 0});
        int sum = 0;

        while(!pq.isEmpty()) {
            int[] val = pq.poll();
            int u = val[1];
            int weight = val[0];
            if(isVisited[u])
                continue;
            isVisited[u] = true;

            sum += weight;
            for(List<Integer> data: adj.get(u)) {
                int node = data.get(0);
                int nodeWeight = data.get(1);

                if(!isVisited[node]) {
                    pq.offer(new int[]{nodeWeight, node});
                }
            }
        }

        return sum;
    }
}

// Time Complexity:O(E log V) where E is the number of edges and V is the number of vertices, due to the priority queue operations.
// Space Complexity:O(V) due to the isVisited array and the priority queue potentially holding up to V vertices.