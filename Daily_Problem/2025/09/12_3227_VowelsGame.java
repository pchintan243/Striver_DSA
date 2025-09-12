package Daily_Problem.2025.09;

public class 12_3227_VowelsGame {
    public boolean doesAliceWin(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a','e','i','o','u':
                    return true;
            }
        }

        return false;
    }
}