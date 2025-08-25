package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_I_BFS {
    public boolean canFinish(int N, int[][] arr) {
        int[] inDegree = new int[N];
        int n = arr.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            adj.get(v).add(u);
            inDegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return cnt == N;
    }
}