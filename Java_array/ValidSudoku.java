public class ValidSudoku {
    boolean dfs(char[][] board, int i, int j, int n, int m, char curr) {
        for(int ll = 0; ll < n; ll++) {
            if(ll != i && board[ll][j] == curr) {
                return false;
            }
        }
        for(int ll = 0; ll < m; ll++) {
            if(ll != j && board[i][ll] == curr) {
                return false;
            }
        }
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for(int ll = row; ll < row + 3; ll++) {
            for(int kk = col; kk < col + 3; kk++) {
                if(ll != i && kk != j && board[ll][kk] == curr) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != '.') {
                    if(!dfs(board, i, j, n, m, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}