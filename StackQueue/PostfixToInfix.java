class PostfixToInfix {
    static String postToInfix(String exp) {
        // code here
        int left = 0;
        Stack<String> st = new Stack<>();
        String ans = "";
        for(char ch : exp.toCharArray()) {
            if((ch >= 'a' && ch <= 'z') ||
            (ch >= 'A' && ch <= 'Z') ||
            (ch >= '0' && ch <= '9')) {
                st.push(Character.toString(ch));
            } else {
                String operand2 = st.pop();  // right-hand operand
                String operand1 = st.pop();  // left-hand operand
                ans = "(" + operand1 + ch + operand2 + ")";
                st.push(ans);
            }
        }
        
        return ans;
    }
}