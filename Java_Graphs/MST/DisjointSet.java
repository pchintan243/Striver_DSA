package Java_Graphs.MST;
import java.util.Arrays;

public class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;
    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public boolean find(int u, int v) {
        return findPair(u) == findPair(v);
    }

    private int findPair(int node) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = findPair(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int ultimateParentU = findPair(u);
        int ultimateParentV = findPair(v);
        if(ultimateParentU == ultimateParentV) 
            return;
        if(rank[ultimateParentU] < rank[ultimateParentV]) {
            parent[ultimateParentU] = ultimateParentV;
        } else if(rank[ultimateParentU] > rank[ultimateParentV]) {
            parent[ultimateParentV] = ultimateParentU;
        } else {
            parent[ultimateParentV] = ultimateParentU;
            rank[ultimateParentU]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findPair(u);
        int ultimateParentV = findPair(v);
        if(ultimateParentU == ultimateParentV) 
            return;
        if(size[ultimateParentU] < size[ultimateParentV]) {
            parent[ultimateParentU] = ultimateParentV;
            size[ultimateParentV] += size[ultimateParentU];
        } else {
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] += size[ultimateParentV];
        } 
    }
}


// Time Complexity:The constructor takes O(n) due to the initialization loop. findPair with path compression has amortized time complexity of nearly O(1). unionByRank and unionBySize have amortized time complexity of nearly O(1) due to findPair.
// Space Complexity:The space complexity is O(n) due to the rank, parent, and size arrays.