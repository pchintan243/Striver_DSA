class 10_3442_FindMaxDiff {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int oddFreq = 0;
        int evenFreq = s.length();
        for(int feq: freq) {
            if((feq & 1) == 1) 
                oddFreq = Math.max(oddFreq, feq);
            if((feq & 1) == 0 && feq > 0)
                evenFreq = Math.min(evenFreq, feq);
        }

        return oddFreq - evenFreq;
    }
}