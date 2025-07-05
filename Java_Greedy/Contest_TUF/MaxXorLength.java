package Contest_TUF;

class MaxXorLength {
    public int maxLenXOR(String s) {
        //your code goes here
        int cntOnes = 0;
        int n = s.length();
        for(char ch: s.toCharArray()) {
            if(ch == '1') {
                cntOnes++;
            }
        }
        if(cntOnes == 0 || (cntOnes & 1) == 1) {
            return n;
        } else {
            int i = 0;
            int j = n - 1;
            while(i < j) {
                if(s.charAt(i) == '1') {
                    return n - i - 1;
                }
                if(s.charAt(j) == '1') {
                    return j;
                }
                i++;
                j--;
            }
        }
        return 1;
    }
}

