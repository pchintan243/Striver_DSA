package Daily_Problem.2026.01;
import java.util.List;

public class 20_3314_MinBitwiseArr {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int ind = 0; ind < n; ind++) {
            int num = nums.get(ind);
            if((num & 1) == 0) {
                ans[ind] = -1;
                continue;
            }
            for(int i = 0; i < num; i++) {
                if((i | (i + 1)) == num) {
                    ans[ind] = i;
                    break;
                }
            }
        }

        return ans;
    }
}