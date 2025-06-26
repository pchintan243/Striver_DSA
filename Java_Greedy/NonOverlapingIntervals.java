import java.io.*;
import java.util.*;

public class NonOverlapingIntervals {
    public static int MaximumNonOverlappingIntervals(int[][] Intervals) {
        //your code goes here
        Arrays.sort(Intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int previousEnd = Integer.MIN_VALUE;
        int cnt = 0;
        for (int[] interval : Intervals) {
            int start = interval[0];
            if (start >= previousEnd) {
                previousEnd = interval[1];
            } else {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] Intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                Intervals[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(MaximumNonOverlappingIntervals(Intervals));
    }
}