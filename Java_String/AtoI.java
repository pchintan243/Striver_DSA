class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        char[] ar = s.toCharArray();
        

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(ar[i])) {
                // System.out.println(11);
                res.append(ar[i]);
            } else if(i == 0 && s.length() > 1 && Character.isDigit(ar[i + 1]) && ar[i] == '-') {
                // System.out.println(0000);
                res.append(ar[i]);
            } else if(i == 0 && ar[i] == '+') {
                continue;
            } else {
                // System.out.println(22);
                break;
            }
        }

        System.out.println(res.toString());

        if(res.length() == 0) {
            return 0;
        }

        if(res.toString().charAt(0) == '-') {
            String st = res.toString().substring(1);
            try {
                int a = Integer.parseInt(st);
                a = -a;
                return a;
            } catch(Exception e) {
                return -2147483648;
            }
        }
        try {
            int a = Integer.parseInt(res.toString());
            return a;
        } catch(Exception e) {
            return 2147483647;
        }
    }
}