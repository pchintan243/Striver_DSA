package SlidingWindow;
import java.util.HashMap;
import java.util.Map;

class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();

        int n = fruits.length;
        int l = 0;
        int r = 0;
        int ans = 0;

        while(r < n) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);
            if(mp.size() > 2) {
                if (mp.get(fruits[l]) == 1) {
                    mp.remove(fruits[l]);
                } else {
                    mp.put(fruits[l], mp.get(fruits[l]) - 1);
                }
                l++;
            }
            
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}