package Daily_Problem.2025.07;
import java.util.Arrays;

public class 29_2411_MaxOrSubArray {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int[] lastSetBit = new int[32]; 
        Arrays.fill(lastSetBit, -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k < 32; k++) {
                if (((nums[i] >> k) & 1) == 1) {
                    lastSetBit[k] = i;
                }
            }

            int minRightmostIndex = i;

            for (int k = 0; k < 32; k++) {
                if (lastSetBit[k] != -1) {
                    minRightmostIndex = Math.max(minRightmostIndex, lastSetBit[k]);
                }
            }
            
            answer[i] = minRightmostIndex - i + 1;
        }

        return answer;
    }
}