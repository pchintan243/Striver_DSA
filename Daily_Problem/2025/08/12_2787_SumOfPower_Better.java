package Daily_Problem.2025.08;
import java.util.Arrays;

// It gives TLE on Big INPUT with small power (x)
public class 12_2787_SumOfPower_Better {
    private final int MOD = (int) 1e9 + 7;

    private int recursion(long sum, int num, int n, int x, int[] powers) {
        if(sum == n) {
            return 1;
        }
        if(num > n) {
            return 0;
        }
        long temp;
        if(powers[num] == -1) {
            temp = ((long) (Math.pow(num, x))) % MOD;
            powers[num] = (int) temp;
        } else {
            temp = powers[num];
        }
        if(sum > n || temp > n) {
            return 0;
        }
        sum = (sum + temp) % MOD;
        int first = recursion(sum, num + 1, n, x, powers);
        sum -= temp;
        int second = recursion(sum, num + 1, n, x, powers);

        return first + second;
    }
    public int numberOfWays(int n, int x) {
        int[] powers = new int[n + 1];
        Arrays.fill(powers, -1);

        return recursion(0, 1, n, x, powers);
    }
}