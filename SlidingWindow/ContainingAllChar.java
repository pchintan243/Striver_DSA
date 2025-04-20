package SlidingWindow;

class ContainingAllChar {
    public int numberOfSubstrings(String s) {
        char[] ch = s.toCharArray();

        int n = ch.length;
        int r = 0;
        int ans = 0;
        int a = -1;
        int b = -1;
        int c = -1;

        while(r < n) {
            if(ch[r] == 'a') {
                a = r;
            } else if(ch[r] == 'b') {
                b = r;
            } else {
                c = r;
            }
            // no need to check if it's -1 or not because inside if block 
            // you done min of that so min always would be -1 and we added + 1 into it
            // so it would be zero

            // if(a != -1 && b != -1 && c != -1) {
            int temp = Math.min(a, b);
            temp = Math.min(temp, c);

            ans += temp + 1;
            // }
            r++;
        }

        return ans;
    }
}