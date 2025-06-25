import java.io.*;
import java.util.*;

public class NMeetingOneRoom {
    public static int maxMeetings(int[] start, int[] end) {
        // your code goes here
        int n = start.length;
        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            pos[i][0] = end[i];
            pos[i][1] = start[i];
        }
        Arrays.sort(pos, Comparator.comparingInt(a -> a[0]));
        int ans = 1;
        int lastMeetingEndTime = pos[0][0];

        for (int i = 1; i < n; i++) {
            int currST = pos[i][1];
            if (currST > lastMeetingEndTime) {
                lastMeetingEndTime = pos[i][0];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] start = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            end[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(maxMeetings(start, end));
    }
}