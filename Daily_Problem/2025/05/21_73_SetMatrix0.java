class 21_73_SetMatrix0 {
    public void setZeroes(int[][] matrix) {
        int first = matrix[0][0];
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        first = 0;
                    } else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if(matrix[0][0] == 0) {
            for(int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if(first == 0) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}