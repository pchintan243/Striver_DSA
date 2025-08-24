package DFS;

public class NumberOfIsland {
    boolean[][] isVisited;
    void dfs(int i, int j, int n, int m, char[][] grid) {
        if(i < 0 || j < 0 || i >= n || j >= m || isVisited[i][j] || grid[i][j] == '0') {
            return;
        }
        isVisited[i][j] = true;
        dfs(i + 1, j, n, m, grid);
        dfs(i - 1, j, n, m, grid);
        dfs(i, j + 1, n, m, grid);
        dfs(i, j - 1, n, m, grid);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        isVisited = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    cnt++;
                    dfs(i, j, n, m, grid);
                }
            }
        }
        return cnt;
    }
}