package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleDirectedGraph_BFS {

    public boolean isCyclic(int N, List<List<Integer>> adj) {
        // Using BFS Kahn's Algorithm
        int[] inDegree = new int[N];

        for(int i = 0; i < N; i++) {
            for(int k: adj.get(i)) {
                inDegree[k]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int v = q.poll();
            ans.add(v);
            for(int k: adj.get(v)) {
                inDegree[k]--;
                if(inDegree[k] == 0) {
                    q.offer(k);
                }
            }
        }

        return ans.size() != N;
    }
}
