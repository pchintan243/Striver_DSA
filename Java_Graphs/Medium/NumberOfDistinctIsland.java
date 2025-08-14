package Java_Graphs.Medium;
import java.util.ArrayList;
import java.util.List;

public class NumberOfDistinctIsland {
    boolean outOfBoundary(int i, int j, int n, int m) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }

    void dfs(int baseI, int baseJ, int i, int j, int n, int m, boolean[][] isVisited, int[][] grid, List<Integer> temp) {
        if(outOfBoundary(i, j, n, m) || grid[i][j] == 0 || isVisited[i][j]) {
            return;
        }
        
        isVisited[i][j] = true;

        temp.add(i - baseI);
        temp.add(j - baseJ);
        dfs(baseI, baseJ, i - 1, j, n, m, isVisited, grid, temp);
        dfs(baseI, baseJ, i + 1, j, n, m, isVisited, grid, temp);
        dfs(baseI, baseJ, i, j - 1, n, m, isVisited, grid, temp);
        dfs(baseI, baseJ, i, j + 1, n, m, isVisited, grid, temp);
    }
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<List<Integer>> set = new HashSet<>();
        boolean[][] isVisited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !isVisited[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    dfs(i, j, i, j, n, m, isVisited, grid, temp);
                    set.add(temp);
                }
            }
        }

        return set.size();
    }
}
