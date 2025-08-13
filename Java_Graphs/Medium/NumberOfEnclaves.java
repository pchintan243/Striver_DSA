package Java_Graphs.Medium;

public class NumberOfEnclaves {
    void dfs(int[][] grid, int row, int col, boolean[][] isVisited, int n, int m) {
        if(row < 0 || row >= n || col < 0 || col >= m || isVisited[row][col] || grid[row][col] == 0) {
            return;
        }

        isVisited[row][col] = true;
        dfs(grid, row, col + 1, isVisited, n, m);
        dfs(grid, row, col - 1, isVisited, n, m);
        dfs(grid, row - 1, col, isVisited, n, m);
        dfs(grid, row + 1, col, isVisited, n, m);
    }
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i][0] && grid[i][0] == 1) {
                dfs(grid, i, 0, isVisited, n, m);
            }
            if (!isVisited[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, isVisited, n, m);
            }
        }
        for (int j = 0; j < m; j++) {
            if (!isVisited[0][j] && grid[0][j] == 1) {
                dfs(grid, 0, j, isVisited, n, m);
            }
            if (!isVisited[n - 1][j] && grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, isVisited, n, m);
            }
        }


        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if(!isVisited[i][j] && grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}