package Daily_Problem.2026.05;

public class 06_1861_RotatingBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] ch = new char[m][n];

        for(int i = n - 1; i >= 0; i--) {
            int emptyInd = m - 1;
            for(int j = m - 1; j >= 0; j--) {
                if(boxGrid[i][j] == '.') 
                    continue;
                if(boxGrid[i][j] == '*') {
                    emptyInd = j - 1;
                    continue;
                }
                if(j != emptyInd) {
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptyInd] = '#';
                }
                emptyInd--;
            }
        }
        for(int j = n - 1; j >= 0; j--) {
            int ind = n - j - 1;
            for(int i = 0; i < m; i++) {
                ch[i][ind] = boxGrid[j][i];
            }
        }
        return ch;
    }
}