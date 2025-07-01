package Daily_Problem.2025.07;

class 01_3330_OriginalTypeString {
    public int possibleStringCount(String word) {
        int cnt = 1;
        char[] ch = word.toCharArray();
        int n = word.length();

        for(int i = 1; i < n; i++) {
            if(ch[i] == ch[i - 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}