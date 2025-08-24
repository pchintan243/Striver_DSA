package Daily_Problem.2025.08;

public class 22_3195_MaxAreaCover1s {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int startI = Integer.MAX_VALUE;
        int startJ = Integer.MAX_VALUE;
        int endI = Integer.MIN_VALUE;
        int endJ = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    startJ = Math.min(startJ, j);
                    startI = Math.min(startI, i);
                    endJ = Math.max(endJ, j);
                    endI = Math.max(endI, i);
                }
            }
        }
        
        return (endJ - startJ + 1) * (endI - startI + 1);
    }
}