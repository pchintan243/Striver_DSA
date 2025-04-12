import java.util.ArrayList;
import java.util.List;
class AsteroidsBruteForce {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ls = new ArrayList<>();

        for(int a : asteroids) {
            ls.add(a);
        }
        int n = asteroids.length;
        for(int i = 1; i < ls.size(); i++) {
            if((ls.get(i) < 0 && ls.get(i - 1) > 0)) {
                if(Math.abs(ls.get(i)) == ls.get(i - 1)) {
                    ls.remove(i);
                    ls.remove(i - 1);
                    i = i - 2;
                } else if(Math.abs(ls.get(i)) < ls.get(i - 1)) {
                    ls.remove(i);
                    i = i - 1;
                } else {
                    ls.remove(i - 1);
                    i = i - 2;
                }
                if(i < 0)
                    i = 0;
            }
        }
        if(ls.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[ls.size()];
        for(int i = 0; i < ls.size(); i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }
}