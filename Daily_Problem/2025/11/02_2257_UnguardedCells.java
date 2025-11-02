package Daily_Problem.2025.11;

public class 02_2257_UnguardedCells {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];

        for(int[] i: walls) {
            mat[i[0]][i[1]] = -1;
        }

        int cnt = (m * n) - walls.length - guards.length;
        for(int[] i: guards) {
            mat[i[0]][i[1]] = -1;
        }

        for(int[] i: guards) {
            int r = i[0];
            int c = i[1];
            for(int j = c + 1; j < n; j++) {
                if(mat[r][j] == -1) {
                    break;
                }
                if(mat[r][j] == 0) {
                    mat[r][j] = 1;
                    cnt--;
                }
            }
            for(int j = c - 1; j >= 0; j--) {
                if(mat[r][j] == -1) {
                    break;
                }
                if(mat[r][j] == 0) {
                    mat[r][j] = 1;
                    cnt--;
                }
            }
            for(int j = r + 1; j < m; j++) {
                if(mat[j][c] == -1) {
                    break;
                }
                if(mat[j][c] == 0) {
                    mat[j][c] = 1;
                    cnt--;
                }
            }
            for(int j = r - 1; j >= 0; j--) {
                if(mat[j][c] == -1) {
                    break;
                }
                if(mat[j][c] == 0) {
                    mat[j][c] = 1;
                    cnt--;
                }
            }
        }

        return cnt;
    }
}