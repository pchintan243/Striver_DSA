import java.io.*;
import java.util.*;

public class InsertIntervals {

    public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1. Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // 2. Merge all overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged interval

        // 3. Add remaining intervals
        while (i < n) {
            result.add(intervals[i++]);
        }

        // Convert result to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] Intervals = new int[n][2];
        int[] newIntervals = new int[2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                Intervals[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        newIntervals[0] = Integer.parseInt(st.nextToken());
        newIntervals[1] = Integer.parseInt(st.nextToken());
        int[][] ints = insertNewInterval(Intervals, newIntervals);
        for (int[] i : ints) {
            System.out.print(i[0] + " ");
            System.out.println(i[1]);
        }
    }
}
