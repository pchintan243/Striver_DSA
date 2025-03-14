class 1st_Complement {
    public int findComplement(int num) {
        StringBuilder ans = new StringBuilder();
        int storeNum = num;
        while(storeNum != 1) {
            if(storeNum % 2 == 1) {
                ans.append('0');
            } else {
                ans.append('1');
            }
            storeNum /= 2;
        }

        int p = 1;
        int n = 0;
        for(char ch : ans.toString().toCharArray()) {
            if(ch == '1') {
                n += p;
            }
            p = p * 2;
        }

        return n;
    }
}