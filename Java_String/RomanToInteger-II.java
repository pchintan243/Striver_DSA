class Solution {
    public int romanToInt(String s) {
        int cnt = 0;
        char[] ar = s.toCharArray();
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for(int i = 0; i < s.length() - 1; i++) {
            if(roman.get(ar[i]) < roman.get(ar[i + 1])) {
                cnt -= roman.get(ar[i]);
            } else {
                cnt += roman.get(ar[i]);
            }
        }
        return cnt + roman.get(ar[s.length() - 1]);
    }
}