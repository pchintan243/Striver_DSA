import java.util.Stack;
class MaxAreaOptimized {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int cnt = heights[st.pop()] * (i - (st.isEmpty() ? -1 : st.peek()) - 1);
                ans = Math.max(cnt, ans);
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int cnt = heights[st.pop()] * (n - (st.isEmpty() ? -1 : st.peek()) - 1);
            ans = Math.max(cnt, ans);
        }

        return ans;
    }
}