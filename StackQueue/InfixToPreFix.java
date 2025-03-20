import java.util.Stack;

class InfixToPreFix {
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
    // Function to convert an infix expression to a prefix expression.
    public static String infixToPrefix(String s) {
        // Your code here
        char[] ch = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;  // Fix: should be length() - 1 since it's an index
        
        while (left <= right) {  // Allow middle char in odd length strings
            // Swap characters at left and right
            char leftChar = ch[left];
            char rightChar = ch[right];
        
            // Invert brackets if they are '(' or ')'
            if (leftChar == '(') leftChar = ')';
            else if (leftChar == ')') leftChar = '(';
        
            if (rightChar == '(') rightChar = ')';
            else if (rightChar == ')') rightChar = '(';
        
            // Swap after flipping
            ch[left] = rightChar;
            ch[right] = leftChar;
        
            left++;
            right--;
        }

        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            if((ch[i] >= 'A' && ch[i] <= 'Z') || 
            (ch[i] >= 'a' && ch[i] <= 'z') ||
            (ch[i] >= '0' && ch[i] <= '9')) {
                ans = ans + ch[i];
            } else if(ch[i] == '(') {
                st.push(ch[i]);
            } else if(ch[i] == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans = ans + st.peek();
                    st.pop();
                }
                if(!st.isEmpty())
                    st.pop();
            } else {
                while(!st.isEmpty() && precedence(ch[i]) < precedence(st.peek())) {
                    ans = ans + st.peek();
                    st.pop();
                }
                st.push(ch[i]);
            }
        }
        while(!st.isEmpty()) {
            ans = ans + st.peek();
            st.pop();
        }
        System.out.println(ans);
        ans = new StringBuilder(ans).reverse().toString();
        
        return ans;
    }
}