import java.util.ArrayList;
import java.util.List;
class LetterCombinationPhoneNumber {
    void recursion(String digits, int n, int ind, List<String> ans, StringBuilder sb) {
        if(ind == n) {
            ans.add(sb.toString());
            return;
        }

        if(digits.charAt(ind) == '2') {
            sb.append("a");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("b");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("c");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '3') {
            sb.append("d");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("e");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("f");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '4') {
            sb.append("g");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("h");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("i");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '5') {
            sb.append("j");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("k");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("l");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '6') {
            sb.append("m");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("n");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("o");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '7') {
            sb.append("p");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("q");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("r");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("s");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '8') {
            sb.append("t");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("u");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("v");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if(digits.charAt(ind) == '9') {
            sb.append("w");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("x");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("y");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
            
            sb.append("z");
            recursion(digits, n, ind + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return List.of();
        }
        List<String> ans = new ArrayList<>();
        recursion(digits, digits.length(), 0, ans, new StringBuilder());
        return ans;
    }
}