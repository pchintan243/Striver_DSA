class 26_03_25_2033MakeUniGrid {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int k = arr.size();
        int median = arr.get(k / 2);
        for(int j = 0; j < arr.size(); j++) {
            if(Math.abs(arr.get(0) - arr.get(j)) % x != 0 ) {
                return -1;
            }
        }
        int cnt = 0;
        for(int val: arr) {
            cnt += Math.abs(val - median) / x;
        }

        return cnt;
    }
}