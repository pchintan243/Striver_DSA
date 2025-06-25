import java.util.Arrays;
class ScheduleJobFirst {
    public long solve(int[] bt) {
        //your code goes here
        Arrays.sort(bt);
        long waitTime = 0;
        long t = 0;
        for(int i = 0; i < bt.length; i++) {
            waitTime += t;
            t += bt[i];
        }

        return waitTime / bt.length;
    }
}