package Daily_Problem.2025.10;
import java.util.Arrays;

public class 08_2300_SpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;

            while(low <= high) {
                int mid = low + (high - low) / 2;
                if((long) potions[mid] * spells[i] >= success) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = m - low;
        }

        return ans;
    }
}