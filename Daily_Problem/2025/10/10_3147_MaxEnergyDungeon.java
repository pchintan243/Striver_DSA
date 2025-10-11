package Daily_Problem.2025.10;

public class 10_3147_MaxEnergyDungeon {
    public int maximumEnergy(int[] energy, int k) {
        int l = energy.length;
        int[] dp = new int[l];
        int result = Integer.MIN_VALUE;
        for (int i = l - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < l ? dp[i + k] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}