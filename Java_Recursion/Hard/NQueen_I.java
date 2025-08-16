package Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen_I {
    List<List<String>> ans;
    boolean canWePut(int i, int j, int n, char[][] board) {
        // above column
        for(int ll = 0; ll < i; ll++) {
            if(board[ll][j] == 'Q') {
                return false;
            }
        }
        // Left Diagnoal
        int maxLeft = Math.min(i, j);
        for(int ll = 1; ll <= maxLeft; ll++) {
            if(board[i - ll][j - ll] == 'Q') {
                return false;
            }
        }

        // Right Diagnoal
        int maxRight = Math.min(i, n - j - 1);
        for(int ll = 1; ll <= maxRight; ll++) {
            if(board[i - ll][j + ll] == 'Q') {
                return false;
            }
        }
        return true;
    }
    void placeQueens(int i, char[][] board, int n) {
        if(i == n) {
            List<String> temp =  new ArrayList<>();
            for(int row = 0; row < n; row++) {
                temp.add(new String(board[row]));
            }
            ans.add(temp);
            return;
        } 
        for(int k = 0; k < n; k++) {
            if(canWePut(i, k, n, board)) {
                board[i][k] = 'Q';
                placeQueens(i + 1, board, n);
                board[i][k] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        placeQueens(0, board, n);

        return ans;
    }
}