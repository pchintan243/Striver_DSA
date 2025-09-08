package Java_Graphs.Hard-II;
import java.util.Arrays;

public class NumberOfOperationToMakeComponentConnected {
    int find(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node], parent);
    }
    public int solve(int n, int[][] Edge) {        
        if(Edge.length + 1 < n) {
            return -1;
        }
        int cnt = 0;
        int edgesCnt = 0;

        boolean[] isVisited = new boolean[n];
        int[] parent = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int m = Edge.length;
        for(int[] e: Edge) {
            int u = e[0];
            int v = e[1];
            int ultU = find(u, parent);
            int ultV = find(v, parent);

            if(ultU == ultV) {
                continue;
            }
            if(size[ultU] < size[ultV]) {
                size[ultV] += size[ultU];
                parent[ultU] = ultV;
            } else {
                size[ultU] += size[ultV];
                parent[ultV] = ultU;
            }
        }

        for(int p = 0; p < n; p++) {
            if(p == parent[p]) {
                cnt++;
            }
        }
        
        return cnt - 1;
    }
} 

// Time Complexity:O(m * alpha(n) + n), where m is the number of edges and alpha(n) is the inverse Ackermann function, which grows very slowly. The n comes from the initialization loop.
// Space Complexity:O(n) due to the parent, size, and isVisited arrays.