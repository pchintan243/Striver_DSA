package Java_Graphs.Medium;

// It's same as Connected Components
class NumberOfProvinces {
    void dfs(int i, boolean[] isVisited, int[][] isConnected, int n) {
        isVisited[i] = true;
        for(int k = 0; k < n; k++) {
            if(!isVisited[k] && isConnected[i][k] == 1) {
                dfs(k, isVisited, isConnected, n);
            }
        }
    
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] isVisited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(i, isVisited, isConnected, n);
                cnt++;
            }
        }

        return cnt;
    }
}