class 21_3085_MinDeletionToMakek {
    public int minimumDeletions(String word, int k) {
        char[] ch = word.toCharArray();
        int[] freq = new int[26];
        for(char c: ch) {
            freq[c - 'a']++;
        }
        int minDecrement = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if(freq[i] == 0) 
                continue;
            int base = freq[i];
            int totalDecrement = 0;

            for (int j = 0; j < 26; j++) {
                if(freq[j]==0)
                    continue;
                if(i == j) 
                    continue;
                if (freq[j] > base + k) {
                    totalDecrement += freq[j] - (base + k);
                } else if (freq[j] < base) {
                    totalDecrement += freq[j];
                }
            }

            minDecrement = Math.min(minDecrement, totalDecrement);
        }

        return minDecrement;
    }
}