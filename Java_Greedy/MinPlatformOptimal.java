import java.util.Arrays;
class MinPlatformOptimal {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here
        int cnt = 1;
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int i = 1;
        int j = 0;
        int n = Arrival.length;
        int maxCnt = 1;
        while(i < n && j < n) {
            if(Arrival[i] <= Departure[j]) {
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }
}
