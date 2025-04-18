import java.util.Stack;
class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        char[] c = num.toCharArray();
        for(int i = 0; i < c.length; i++) {
            while(!st.isEmpty() && (st.peek() > (c[i] - '0')) && k != 0) {
                st.pop();
                k--;
            }
            st.push(c[i] - '0');
        }
        if(st.isEmpty()) {
            return "0";
        }
        while(k != 0) {
            st.pop();
            k--;
        }
        StringBuilder s = new StringBuilder();
        while(!st.isEmpty()) {
            s.append(st.pop());
        }
        while(s.length() != 0 && s.charAt(s.length() - 1) == '0') {
            s.deleteCharAt(s.length() - 1);
        }
        s = s.reverse();

        if(s.isEmpty()) {
            return "0";
        }
        return s.toString();
    }
}