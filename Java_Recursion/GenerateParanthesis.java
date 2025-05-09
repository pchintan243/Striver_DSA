import java.util.ArrayList;
import java.util.List;
class GenerateParanthesis {
    public boolean isValid(StringBuilder s, int n) {
        int cnt = 0;
        for(char ch : s.toString().toCharArray()) {
            if(ch == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if(cnt < 0 || cnt > n) {
                return false;
            }
        }
        return cnt == 0;
    }
    public void generateCombination(String s, int open, int close, int n, List<String> ans) {
        if(open + close == (n * 2)) {
            ans.add(s.toString());
            return;
        }

        if(open < n)
            generateCombination(s + "(", open + 1, close, n, ans);
        if(close < open)
            generateCombination(s + ")", open, close + 1, n, ans);
    }

    public List<String> generateParenthesis(int n) {
        //your code goes here
        List<String> ans = new ArrayList<>();
        generateCombination("", 0, 0, n, ans);
        return ans;
    }
}