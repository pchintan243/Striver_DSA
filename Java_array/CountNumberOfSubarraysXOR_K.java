import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubarraysXOR_K {

    public int solve(int[] A, int B) {

        Map<Integer, Integer> mpp = new HashMap<>();
        int cnt = 0;
        mpp.put(0, 1);
        int xr = 0;
        for (int i = 0; i < A.length; i++) {
            xr ^= A[i];
            cnt += mpp.getOrDefault(xr ^ B, 0);
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }

        return cnt;
    }

}
