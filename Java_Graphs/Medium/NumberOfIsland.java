package Java_Graphs.Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NumberOfIsland {
    /**
     *  For Better Readability:- no need to check upper & lower it will handle by itself
     */

    // void markVisited(int i, int j, char[][] grid, boolean[][] isVisited, int n, int m) {
    //     Queue<List<Integer>> q = new LinkedList<>();
    //     q.offer(List.of(i, j));
    //     isVisited[i][j] = true;

    //     while(!q.isEmpty()) {
    //         List<Integer> lst = q.poll();
    //         int first = lst.get(0);
    //         int second = lst.get(1);
    //         for(int row = -1; row <= 1; row++) {
    //             int k = first + row;
    //             if(k == -1) {
    //                 continue;
    //             }
    //             for(int col = -1; col <= 1; col++) {
    //                 int l = second + col;

    //                 if(k >= 0 && k < n && l >= 0 && l < m && grid[k][l] == '1' && !isVisited[k][l]) {
    //                     q.offer(List.of(k, l));
    //                     isVisited[k][l] = true;
    //                 }
    //             }
    //         }
    //     }
    // }
    void markVisited(int n, int m, char[][] grid, boolean[][] isVisited, Queue<List<Integer>> q) {
        while(!q.isEmpty()) {
            List<Integer> lst = q.poll();
            int first = lst.get(0);
            int second = lst.get(1);
            if(!isVisited[first][second]) {
                isVisited[first][second] = true;
                if(first > 0) {
                    if(grid[first - 1][second] == '1' && !isVisited[first - 1][second]) {
                        q.offer(List.of(first - 1, second));
                    }
                    if(second > 0 && grid[first - 1][second - 1] == '1' && !isVisited[first - 1][second - 1]) {
                        q.offer(List.of(first - 1, second - 1));
                    }
                    if(second < (m - 1) && grid[first - 1][second + 1] == '1' && !isVisited[first - 1][second + 1]) {
                        q.offer(List.of(first - 1, second + 1));
                    }
                }
                if(first < (n - 1)) {
                    if(grid[first + 1][second] == '1' && !isVisited[first + 1][second]) {
                        q.offer(List.of(first + 1, second));
                    }
                    if(second > 0 && grid[first + 1][second - 1] == '1' && !isVisited[first + 1][second - 1]) {
                        q.offer(List.of(first + 1, second - 1));
                    }
                    if(second < (m - 1) && grid[first + 1][second + 1] == '1' && !isVisited[first + 1][second + 1]) {
                        q.offer(List.of(first + 1, second + 1));
                    }
                }
                if(second > 0 && grid[first][second - 1] == '1' && !isVisited[first][second - 1]) {
                    q.offer(List.of(first, second - 1));
                }
                if(second < (m - 1) && grid[first][second + 1] == '1' && !isVisited[first][second + 1]) {
                    q.offer(List.of(first, second + 1));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];

        int cnt = 0;
        Queue<List<Integer>> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    cnt++;
                    q.offer(List.of(i, j));
                    markVisited(n, m, grid, isVisited, q);
                }
            }
        }

        return cnt;
    }
}

