class PostToPre {
    static String postToPre(String s) {
        // code here
        
        Stack<String> st = new Stack<>();
        String ans = "";
        char[] ch = s.toCharArray();
        for(char c : ch) {
            if((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9')) {
                st.push(Character.toString(c));
            } else {
                String operand2 = st.pop();  // right-hand operand
                String operand1 = st.pop();  // left-hand operand
                ans = c + operand1 + operand2;
                st.push(ans);
            }
        }
        
        return st.pop();
    }
}
