package Daily_Problem.2025.10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 05_417_AtlanticPacificWaterFlow {
    private int m, n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if(!pacific[0][j])
                dfs(0, j, heights, pacific);
        }
        for (int i = 0; i < m; i++) {
            if(!pacific[i][0])
                dfs(i, 0, heights, pacific);
        }
        for (int j = 0; j < n; j++) {
            if(!atlantic[m - 1][j])
                dfs(m - 1, j, heights, atlantic);
        }
        for (int i = 0; i < m; i++) {
            if(!atlantic[i][n - 1])
                dfs(i, n - 1, heights, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n || heights[x][y] < heights[i][j])    
                continue;
            if (!visited[x][y])
                dfs(x, y, heights, visited);
        }
    }
}