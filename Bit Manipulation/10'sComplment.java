class 10'sComplment {
    public int bitwiseComplement(int num) {
        if(num == 0) {
            return 1;
        }
        StringBuilder ans = new StringBuilder();
        int storeNum = num;
        while(storeNum != 1) {
            if((storeNum & 1) == 1) {
                ans.append('0');
            } else {
                ans.append('1');
            }
            storeNum = storeNum >> 1;
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