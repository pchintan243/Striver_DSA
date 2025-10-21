package Daily_Problem.2025.10;
import java.util.Arrays;

public class 21_3346_MaxOperationsAfterPerform {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = Arrays.stream(nums).max().getAsInt() + k + 2;
        int res = 0;
        int[] cnt = new int[max];
        for(int v: nums) {
            cnt[v]++;
        }

        for(int i = 1; i < max; i++) {
            cnt[i] += cnt[i - 1];
        }

        for(int i = 0; i < max; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(max - 1, i + k);

            int total = cnt[right] - (left > 0 ? cnt[left - 1] : 0);
            int freq = cnt[i] - (i > 0 ? cnt[i - 1] : 0);
            res = Math.max(res, freq + Math.min(numOperations, total - freq));
        }

        return res;
    }
}