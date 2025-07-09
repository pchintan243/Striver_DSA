package Daily_Problem.2025.07;

public class 09_3439_RescheduleMeeting {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] prefixSum = new int[n + 1];
        int maxFree = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            int occupied = prefixSum[i + 1] - prefixSum[i - k + 1];
            int windowEnd = (i == n - 1) ? eventTime : startTime[i + 1];
            int windowStart = (i == k - 1) ? 0 : endTime[i - k];
            int freeTime = windowEnd - windowStart - occupied;
            maxFree = Math.max(maxFree, freeTime);
        }

        return maxFree;

    }
}