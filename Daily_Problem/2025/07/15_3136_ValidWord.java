package Daily_Problem.2025.07;

public class 15_3136_ValidWord {
    public boolean isValid(String word) {
        int n = word.length();
        // Rule 1: It contains a minimum of 3 characters.
        if(n < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;

        // Using a predefined string for quick vowel lookup (case-insensitive)
        String vowels = "aeiouAEIOU";

        for(char c: word.toCharArray()) {
            // Rule 2: It contains only digits (0-9), and English letters (uppercase and lowercase).
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            c = Character.toLowerCase(c);

            // Check if the character is an English letter (distinguishing it from a digit)
            if (Character.isLetter(c)) {
                // Rule 3: It includes at least one vowel.
                // Check if the current letter is present in our vowels string
                if (vowels.indexOf(c) != -1) { // If 'c' is found in the vowels string
                    hasVowel = true;
                } else {
                    // Rule 4: It includes at least one consonant.
                    // If it's a letter and not a vowel, it must be a consonant.
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
        
    }
}