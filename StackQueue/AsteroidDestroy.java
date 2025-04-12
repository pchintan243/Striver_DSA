import java.util.Stack;
class AsteroidDestroy {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        boolean flag;
        for(int i = 0; i < n; i++) {
            flag = true;
            while((!st.isEmpty() && st.peek() > 0) && (asteroids[i] < 0)) {
                if(st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                    flag = false;
                    break;
                } else if(st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag)
                st.push(asteroids[i]);
        }
        if(st.isEmpty()) {
            return new int[0];
        }
        int[] ans = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}