package Java_Graphs.Hard;
import java.util.*;

public class Kahn_sAlgo_BFS {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        // Using BFS Kahn's Algorithm
        int[] inDegree = new int[V];

        for(int i = 0; i < V; i++) {
            for(int k: adj.get(i)) {
                inDegree[k]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int ind = 0;
        int[] ans = new int[V];

        while(!q.isEmpty()) {
            int v = q.poll();
            ans[ind++] = v;
            for(int k: adj.get(v)) {
                inDegree[k]--;
                if(inDegree[k] == 0) {
                    q.offer(k);
                }
            }
        }
        return ans;
    }
}