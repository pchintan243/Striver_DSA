package Java_Graphs.Hard-II;
import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland_II {
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        int len = n * m;
        int[] parent = new int[len];
        int[] size = new int[len];
        int[][] vis = new int[n][m];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;

        for(int[] data: A) {
            int row = data[0];
            int col = data[1];

            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;

            for(int i = 0; i < 4; i++) {
                int r = row + delRow[i];
                int c = col + delCol[i];
                if(r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == 1) {
                    int nodeNo = row * m + col;
                    int adjNodeNo = r * m + c;
                    if(find(nodeNo, parent) != find(adjNodeNo, parent)) {
                        cnt--;
                        makeSize(nodeNo, parent, adjNodeNo, size);
                    }
                }
            }
            ans.add(cnt);
        }

        return ans;
    }


    void makeSize(int u, int[] parent, int v, int[] size) {
        int ulU = find(u, parent);
        int ulV = find(v, parent);
        if(ulU == ulV) {
            return;
        }

        if(size[ulU] < size[ulV]) {
            parent[ulU] = ulV;
            size[ulV] += size[ulU];
        } else {
            parent[ulV] = ulU;
            size[ulU] += size[ulV];
        }
    }

    int find(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = find(parent[node], parent);
    }
}



// Time Complexity:O(L * (4 * O(find) + 1)) where L is the length of A and O(find) is nearly O(1) due to path compression, effectively O(L).
// Space Complexity:O(n*m) due to the parent, size and vis array.