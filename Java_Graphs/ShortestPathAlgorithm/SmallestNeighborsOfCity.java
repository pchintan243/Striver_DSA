package Java_Graphs.ShortestPathAlgorithm;

public class SmallestNeighborsOfCity {
    public int findCity(int n, int m, int edges[][], int distanceThreshold) {
        int[][] grid = new int[n][n];
        for(int[] e: edges) {
            grid[e[0]][e[1]] = e[2];
            grid[e[1]][e[0]] = e[2];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || grid[j][i] == 0) {
                    continue;
                }
                for(int k = 0; k < n; k++) {
                    if(k == j || k == i || grid[i][k] == 0) {
                        continue;
                    }

                    if(grid[j][k] == 0) {
                        grid[j][k] = grid[j][i] + grid[i][k];
                    } else {
                        grid[j][k] = Math.min(grid[j][k], grid[j][i] + grid[i][k]);
                    }
                }
            }
        }

        int ans = 0;
        int maxCity = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            int dist = 0;
            for(int k = 0; k < n; k++) {
                if(k == j || grid[j][k] == 0) {
                    continue;
                }

                if(grid[j][k] <= distanceThreshold) {
                    dist++;
                }
            }
            if(dist <= maxCity) {
                maxCity = dist;
                ans = j;
            }
        }

        return ans;
    }
}

// Time Complexity:O(n^3) due to the nested loops iterating through the grid for the Floyd-Warshall algorithm and finding reachable cities.
// Space Complexity:O(n^2) to store the adjacency matrix representing the graph.