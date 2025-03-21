class PrefixToInfix {
    static String reverse(String s) {
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
        
        return new String(ch);
    }
    static String preToInfix(String s) {
        // code here
        s = reverse(s);
        char[] ch = s.toCharArray();
        
        Stack<String> st = new Stack<>();
        String ans = "";
        for(char c : ch) {
            if((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9')) {
                st.push(Character.toString(c));
            } else {
                String operand2 = st.pop();  // right-hand operand
                String operand1 = st.pop();  // left-hand operand
                ans = "(" + operand1 + c + operand2 + ")";
                st.push(ans);
            }
        }
        ans = st.pop();
        return reverse(ans);
    }
}
