import java.io.*;
import java.util.*;

public class JobSequencing {
    public static int[] JobScheduling(int[][] Jobs) {
        //your code goes here
        int n = Jobs.length;
        int profitEarned = 0;
        int maxDeadline = 0;
        for(int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }
        int[] deadLines = new int[maxDeadline + 1];
        Arrays.fill(deadLines, -1);

        Arrays.sort(Jobs, (a, b) -> Integer.compare(b[2], a[2]));
        int jobCnt = 0;
        for(int i = 0; i < n; i++) {
            int deadline = Jobs[i][1];
            while(deadline != 0) {
                if(deadLines[deadline] == -1) {
                    deadLines[deadline] = 1;
                    break;
                }
                deadline--;
            }
            if(deadline != 0) {
                jobCnt++;
                profitEarned += Jobs[i][2];
            }
        }
        return new int[]{jobCnt, profitEarned};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
            jobs[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(JobScheduling(jobs)));
    }
}
