package Daily_Problem.2025.09;

public class 13_3541_MostFrequentVowel {
    public int maxFreqSum(String s) {
        int[] num = new int[26];
        int vowel = 0;
        int consonant = 0;
        boolean[] isVowel = new boolean[128];
        for(char c: "aeiou".toCharArray()) {
            isVowel[c] = true;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num[c - 'a']++;
            if(isVowel[c]) {
                vowel = Math.max(vowel, num[c - 'a']);
            } else {
                consonant = Math.max(consonant, num[c - 'a']);
            }
        }

        return vowel + consonant;
    }
}