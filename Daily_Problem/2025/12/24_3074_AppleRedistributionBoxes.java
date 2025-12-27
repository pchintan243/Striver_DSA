package Daily_Problem.2025.12;
import java.util.Arrays;

public class 24_3074_AppleRedistributionBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i: apple) {
            sum += i;
        }

        Arrays.sort(capacity);
        int ans = 0;
        for(int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            ans++;
            if(sum <= 0) {
                return ans;
            }
        }

        return ans;
    }
}