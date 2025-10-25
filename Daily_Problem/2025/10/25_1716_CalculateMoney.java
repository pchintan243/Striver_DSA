package Daily_Problem.2025.10;

public class 25_1716_CalculateMoney {
    public int totalMoney(int n) {
        if(n <= 7) {
            return n * (n + 1) / 2;
        }
        int div = n / 7;
        int rem = n % 7;

        int ans = (28 * div);
        int start = div + 1;
        while(div-- > 0) {
            ans += div * 7;
        }
        while(rem-- > 0) {
            ans += start++;
        }
        return ans;
    }
}
