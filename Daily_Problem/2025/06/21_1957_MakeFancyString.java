public class 21_1957_MakeFancyString {
    public String makeFancyString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        ans.append(ch[0]);
        int cnt = 1;
        for(int i = 1; i < s.length(); i++) {
            if(cnt == 2 && ch[i] == ch[i - 1]) {
                continue;
            }
            ans.append(ch[i]);
            if(ch[i] != ch[i - 1])
                cnt = 1;
            else 
                cnt++;
        }
        return ans.toString();
    }
}