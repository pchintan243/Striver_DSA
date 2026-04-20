package Daily_Problem.2026.04;

public class 20_2078_TwoFurthestHouse {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int ans = 0;
        for(int i = 0; i < n - 1; i++) {
            if(colors[i] != colors[n - 1]) {
                ans = Math.max(ans, n - 1 - i);
                break;
            }
        }
        for(int i = n - 1; i > 0; i--) {
            if(colors[i] != colors[0]) {
                ans = Math.max(ans, i);
                break;
            }
        }
        return ans;
    }
}