class 10_02_25_3174 {
    public String clearDigits(String s) {
        if(s.isEmpty() || s.equals(""))
            return "";
        StringBuilder st = new StringBuilder();
        int cnt = 0;
        char[] str = s.toCharArray();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(Character.isDigit(str[i])) {
                cnt++;
                continue;
            }
            if(cnt == 0 && !Character.isDigit(str[i])) {
                st.append(str[i]);
            } else {
                cnt--;
            }
        }
        st.reverse();
        return st.toString();
    }
}