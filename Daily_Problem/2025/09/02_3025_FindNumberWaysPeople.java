package Daily_Problem.2025.09;

public class 02_3025_FindNumberWaysPeople {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];
            for (int j = 0; j < n; j++) {
                int[] pointB = points[j];
                if (i == j || pointA[0] > pointB[0] || pointA[1] < pointB[1]) {
                    continue;
                }

                if (n == 2) {
                    return 1;
                }

                boolean illegal = false;
                for (int k = 0; k < n; k++) {
                    int[] pointC = points[k];
                    if (k == i || k == j) {
                        continue;
                    }

                    if ((pointC[0] >= pointA[0] && pointC[0] <= pointB[0])
                            && (pointC[1] <= pointA[1] && pointC[1] >= pointB[1])) {
                        illegal = true;
                        break;
                    }
                }

                if (!illegal) {
                    ans++;
                }
            }
        }

        return ans;
    }
}