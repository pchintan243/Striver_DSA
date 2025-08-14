class 14_2264_Largest3DigitString {
    public String largestGoodInteger(String num) {
        int n = num.length();

        if(n < 3) {
            return "";
        }
        char[] ch = num.toCharArray();
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++) {

            cnt = (ch[i - 1] == ch[i]) ? cnt + 1 : 1;

            if(cnt == 3) {
                if(sb.length() == 0 || sb.charAt(0) < ch[i]) {
                    sb = new StringBuilder();
                    sb.append(ch[i]).append(ch[i]).append(ch[i]);
                }
            }
        }
        return sb.toString();
    }
}