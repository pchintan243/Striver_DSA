class 22_2138_DivideStringGroupSizeK {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[((n + k - 1) / k)];
        int ind = 0;
        for(int i = 0; i < n; i = i + k) {
            if(i + k < n) {
                String temp = s.substring(i, i + k);
                ans[ind++] = temp;
            } else {
                String temp = s.substring(i, n);
                int size = k - temp.length();
                temp = temp + String.valueOf(fill).repeat(size);
                ans[ind++] = temp;
            }
        }
        return ans;
    }
}