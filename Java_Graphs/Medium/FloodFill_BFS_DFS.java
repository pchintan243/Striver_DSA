package Java_Graphs.Medium;

public class FloodFill_BFS_DFS {
    void bfs(int n, int m, int[][] image, boolean[][] isVisited, int i, int j, int initialValue, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        isVisited[i][j] = true;
        image[i][j] = newColor;
        while(!q.isEmpty()) {
            int[] val = q.poll();
            int first = val[0];
            int second = val[1];

            for(int row = -1, col = -1; row <= 1 && col <= 1; row = row + 2, col = col + 2) {
                int sr = row + first;
                if(sr >= 0 && sr < n && (initialValue == image[sr][second]) && !isVisited[sr][second]) {
                    isVisited[sr][second] = true;
                    q.offer(new int[]{sr, second});
                    image[sr][second] = newColor;
                }

                int sc = col + second;
                if(sc >= 0 && sc < m &&
                        (initialValue == image[first][sc]) && !isVisited[first][sc]) {
                    isVisited[first][sc] = true;
                    q.offer(new int[]{first, sc});
                    image[first][sc] = newColor;
                }
            }
        }
    }
    void dfs(int[][] image, int row, int col, int newColor, int initialVal, boolean[][] isVisited, int n, int m) {
        if(row < 0 || row >= n || col < 0 || col >= m || isVisited[row][col] || image[row][col] != initialVal) {
            return;
        }

        image[row][col] = newColor;
        isVisited[row][col] = true;
        dfs(image, row, col + 1, newColor, initialVal, isVisited, n, m);
        dfs(image, row, col - 1, newColor, initialVal, isVisited, n, m);
        dfs(image, row - 1, col, newColor, initialVal, isVisited, n, m);
        dfs(image, row + 1, col, newColor, initialVal, isVisited, n, m);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] isVisited = new boolean[n][m];

        // bfs(n, m, image, isVisited, sr, sc, image[sr][sc], newColor);
        dfs(image, sr, sc, newColor, image[sr][sc], isVisited, n, m);

        return image;
    }
}