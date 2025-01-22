class Solution {
    public int romanToInt(String s) {
        int cnt = 0;
        char[] ar = s.toCharArray();
        for(int i = 0; i < ar.length; i++) {
            if(ar[i] == 'M') {
                if(i > 0 && ar[i - 1] == 'C') {
                    cnt -= 200;
                }
                cnt += 1000;
            } else if(ar[i] == 'D') {
                if(i > 0 && ar[i - 1] == 'C') {
                    cnt -= 200;
                }
                cnt += 500;
            } else if(ar[i] == 'C') {
                if(i > 0 && ar[i - 1] == 'X') {
                    cnt -= 20;
                }
                cnt += 100;    
            } else if(ar[i] == 'L') {
                if(i > 0 && ar[i - 1] == 'X') {
                    cnt -= 20;
                }
                cnt += 50;
            } else if(ar[i] == 'X') {
                cnt += 10;
                if(i > 0 && ar[i - 1] == 'I') {
                    cnt -= 2;
                }
            } else if(ar[i] == 'V') {
                if(i > 0 && ar[i - 1] == 'I') {
                    cnt -= 2;
                }
                cnt += 5;    
            } else {
                cnt += 1;
            } 
        }
        return cnt;
    }
}