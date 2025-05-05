class 06_03_2025_2965Missing_Repeating {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int missing = -1;
        int repeated = -1;
        int[] freq = new int[size + 1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        for(int num = 1; num <= size; num++) {
            if(freq[num] == 2)
                repeated = num;
            if(freq[num] == 0)
                missing = num;
        }
        return new int[]{repeated, missing};
    }
}