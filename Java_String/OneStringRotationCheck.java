class Solution {
    public boolean rotateString(String s, String goal) {
        int slen = s.length();
        int goallen = goal.length();

        if(slen != goallen) {
            return false;
        }
        int cnt = 0;
        int j = 0;
        for(int i = 0; i < goallen; i++) {
            if(s.charAt(j) == goal.charAt(i)) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);

        for(int i = 0; i < slen; i++) {
            if(cnt == goallen) {
                cnt = 0;
            }
            if(s.charAt(i) != goal.charAt(cnt)) {
                return false;
            }
            cnt++;
        }

        return true;

    }
}