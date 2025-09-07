package Java_Graphs.ShortestPathAlgorithm;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationReachEnd {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) {
            return 0;
        }
        final int MOD = 100000;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, start});
        boolean[] visited = new boolean[MOD];

        while(!q.isEmpty()) {
            int val[] = q.poll();
            int step = val[0];
            int sum = val[1];
            for(int data: arr) {
                int temp = (sum * data) % MOD;
                if(temp == end) {
                    return step + 1;
                }

                if(!visited[temp]) {
                    q.offer(new int[]{step + 1, temp});
                    visited[temp] = true;
                }
            }
        }

        return -1;
    }
}


// Time Complexity:O(100000 * N) where N is the length of the array arr, due to the queue potentially visiting all possible states (0-99999) and iterating through the array arr in each state.
// Space Complexity:O(100000) due to the boolean array visited and the queue which can, in the worst case, hold all possible states.