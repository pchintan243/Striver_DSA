package Daily_Problem.2025.08;

public class 19_2348_ZeroFilledSubArray {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long continuousCnt = 0;
        for(int i: nums) {
            if(i == 0) {
                continuousCnt++;
                ans += continuousCnt;
            } else {
                continuousCnt = 0;
            }
        }

        return ans;
    }
}