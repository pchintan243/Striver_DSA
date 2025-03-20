class InfixToPostFix {
    static int precedence(char ch)
    {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(char ch : s.toCharArray()) {
            if((ch >= 'A' && ch <= 'Z') || 
            (ch >= 'a' && ch <= 'z') ||
            (ch >= '0' && ch <= '9')) {
                ans = ans + ch;
            } else if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans = ans + st.peek();
                    st.pop();
                }
                if(!st.isEmpty())
                    st.pop();
            } else {
                while(!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
                    ans = ans + st.peek();
                    st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()) {
            ans = ans + st.peek();
            st.pop();
        }
        return ans;
    }
}