package DFS;

public class WordSearch {
    boolean dfs(int i, int j, char[][] board, String word, int ind, int n, int m) {
        if (ind == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(ind)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean isFound = dfs(i + 1, j, board, word, ind + 1, n, m) ||
                        dfs(i - 1, j, board, word, ind + 1, n, m) ||
                        dfs(i, j + 1, board, word, ind + 1, n, m) ||
                        dfs(i, j - 1, board, word, ind + 1, n, m);
        board[i][j] = temp;
        return isFound;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, board, word, 0, n, m)) {
                    return true;
                }
            }
        }
        return false;
    }
}