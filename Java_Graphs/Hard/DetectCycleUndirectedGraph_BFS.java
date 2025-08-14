import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] isVisited = new boolean[V];
        for(int i = 0; i < adj.length; i++) {
            if(isVisited[i]) {
                continue;
            }
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{i, -1});
            while(!q.isEmpty()) {
                int[] val = q.poll();
                int vertices = val[0];
                int cameFrom = val[1];
                isVisited[vertices] = true;
                
                for(Integer v: adj[vertices]) {
                    // If not visited then mark it as visited
                    if(!isVisited[v]) {
                        isVisited[v] = true;
                        q.offer(new int[]{v, vertices});
                    } else if(v != cameFrom){
                        // Visited and not came from the parent node it means there must be a cycle.
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
