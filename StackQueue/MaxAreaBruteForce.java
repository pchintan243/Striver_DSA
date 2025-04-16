import java.util.Stack;
class MaxAreaBruteForce {
    public void findPSE(int[] arr, int[] pse, int n) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public void findNSE(int[] arr, int[] nse, int n) {
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = heights[n - 1];
        int[] pse = new int[n];
        int[] nse = new int[n];
        findPSE(heights, pse, n);
        findNSE(heights, nse, n);
        for(int i = 0; i < n; i++) {
            int cnt;

            if(pse[i] == -1) {
                cnt = nse[i] * heights[i];
            } else {
                cnt = (nse[i] - pse[i] - 1) * heights[i];
            }
        
            ans = Math.max(cnt, ans);
        }

        return ans;
    }
}