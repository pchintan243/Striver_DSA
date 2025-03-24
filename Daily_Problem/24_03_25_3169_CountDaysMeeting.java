class 24_03_25_3169_CountDaysMeeting {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int n = meetings.length;
        int ans = 0;
        if(meetings[0][0] != 1) {
            ans = meetings[0][0] - 1;
        }
        int max = 0;
        for(int i = 0; i < n - 1; i++) {
            max = Math.max(meetings[i][1], max);
            if(max < meetings[i + 1][0]) {
                ans += meetings[i + 1][0] - max - 1;
            } else if(max < meetings[i + 1][1]) {
                max = Math.max(meetings[i][1], meetings[i + 1][1]);
            }
        }
        max = Math.max(meetings[n - 1][1], max);
        if(meetings[n - 1][1] < days) {
            ans += days - max;
        }

        return ans;
    }
}