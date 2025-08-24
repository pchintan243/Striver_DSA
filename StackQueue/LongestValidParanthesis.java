import java.util.Stack;
public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); // Push a base index
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else { // ch == ')'
                st.pop();
                if (st.isEmpty()) {
                    // This ')' has no matching '(', so it becomes the new base
                    st.push(i);
                } else {
                    // We found a valid pair, calculate the length
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }
}