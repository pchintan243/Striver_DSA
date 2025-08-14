package Java_Graphs.Medium;

class SurroundedRegions {
    boolean outOfBoundary(int i, int j, int n, int m) {
        return i < 0 || j < 0 || i >= n || j >= m;
    }
    void dfs(int i, int j, int n, int m, boolean[][] isVisited, char[][] mat) {
        if(outOfBoundary(i, j, n, m) || mat[i][j] == 'X' || isVisited[i][j]) {
            return;
        }
        isVisited[i][j] = true;
        
        dfs(i - 1, j, n, m, isVisited, mat);
        dfs(i + 1, j, n, m, isVisited, mat);
        dfs(i, j - 1, n, m, isVisited, mat);
        dfs(i, j + 1, n, m, isVisited, mat);
    }
    public char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            if(mat[0][i] == 'O' && !isVisited[0][i]) {
                dfs(0, i, n, m, isVisited, mat);
            }
            if(mat[n - 1][i] == 'O' && !isVisited[n - 1][i]) {
                dfs(n - 1, i, n, m, isVisited, mat);
            }
        }
        for(int j = 1; j < n - 1; j++) {
            if(mat[j][0] == 'O' && !isVisited[j][0]) {
                dfs(j, 0, n, m, isVisited, mat);
            }
            if(mat[j][m - 1] == 'O' && !isVisited[j][m - 1]) {
                dfs(j, m - 1, n, m, isVisited, mat);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 'O' && !isVisited[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }
}