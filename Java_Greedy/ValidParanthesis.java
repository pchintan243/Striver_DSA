package Java_Greedy;

public class ValidParanthesis {
    static boolean checkValidString(String s) {
        int minOpen = 0; // minimum possible open brackets
        int maxOpen = 0; // maximum possible open brackets

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                if (minOpen > 0) minOpen--;
                maxOpen--;
            } else { // '*'
                if (minOpen > 0) minOpen--; // treat '*' as ')'
                maxOpen++; // treat '*' as '('
            }

            if (maxOpen < 0) return false; // too many ')'
        }

        return minOpen == 0;
    }
    public static void main(String[] args) {
        System.out.println(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
    }

}