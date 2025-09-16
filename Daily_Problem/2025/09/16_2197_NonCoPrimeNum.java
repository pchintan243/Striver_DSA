package Daily_Problem.2025.09;
import java.util.ArrayList;
import java.util.List;

public class 16_2197_NonCoPrimeNum {
    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long current = nums[i];
            while (!ans.isEmpty()) {
                long gcd = gcd(current, ans.get(ans.size() - 1));
                if(gcd <= 1) {
                   break; 
                }
                long last = ans.remove(ans.size() - 1);
                current = (current * last) / gcd;
            }
            ans.add((int) current);
        }
        return ans;
    }
}