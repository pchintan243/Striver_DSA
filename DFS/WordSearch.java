package DFS;

public class WordSearch {
    int[] delRow = new int[]{-1, 0, 0, 1};
    int[] delCol = new int[]{0, -1, 1, 0};
    int n, m;

    boolean dfs(int i, int j, char[][] board, String word, int ind, boolean[][] isVisited) {
        if (ind == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= n || j >= m || isVisited[i][j] || board[i][j] != word.charAt(ind)) {
            return false;
        }

        isVisited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];

            if (dfs(newRow, newCol, board, word, ind + 1, isVisited)) {
                return true;
            }
        }

        isVisited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // Pass a new isVisited array for each potential starting point
                    boolean[][] isVisited = new boolean[n][m];
                    if (dfs(i, j, board, word, 0, isVisited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}