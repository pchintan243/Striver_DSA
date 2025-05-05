class 11_04_2025_2843_ContSymmetric {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i = low; i <= high; i++) {
            if(i >= 100 && i < 999) {
                i = 999;
            }
            String s = String.valueOf(i);
            int len = s.length();
            if(len % 2 != 0) {
                continue;
            }

            int half = len / 2;
            int left = 0;
            int right = 0;

            for(int j = 0; j < half; j++) {
                left += s.charAt(j);
            }

            for(int j = half; j < len; j++) {
                right += s.charAt(j);
            }

            if(left == right) {
                cnt++;
            }
        }

        return cnt;
    }
}