class Solution {
    public boolean rotateString(String s, String goal) {
        int slen = s.length();
        int goallen = goal.length();
        if(slen != goallen) {
            return false;
        }
        return (s + s).contains(goal);
    }
}