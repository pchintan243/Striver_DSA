package Daily_Problem.2026.01;
import java.util.Stack;

public class 11_85_MaxRectangleArea {
    public int findMax(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                int cnt = nums[st.pop()] * (i - (st.isEmpty() ? -1 : st.peek()) - 1);
                ans = Math.max(cnt, ans);
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int cnt = nums[st.pop()] * (n - (st.isEmpty() ? -1 : st.peek()) - 1);
            ans = Math.max(cnt, ans);
        }
        st.clear();

        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] nums = new int[n][m];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                nums[i][j] = matrix[i][j] == '1' ? 1 : 0;
                if(i != 0 && nums[i][j] != 0)
                    nums[i][j] = nums[i - 1][j] + 1;
            }
            int temp = findMax(nums[i]);
            ans = Math.max(ans, temp);
        }
        
        return ans;

    }
}