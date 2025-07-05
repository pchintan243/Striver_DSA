package Contest_TUF;

import java.util.Map;
import java.util.TreeMap;

class UnPalinDromicString {
    public int unPalindrome(String s) {
        int n = s.length();

        // Condition 1: If length is odd, it's impossible to satisfy rule 1 for the middle character.
        // Condition 2: If length > 26, it's impossible to have all unique characters.
        if (n % 2 != 0 || n > 26) {
            return -1;
        }

        int totalCost = 0;
        // Use a boolean array to keep track of characters already "taken"
        // (meaning they are part of the unique set in the final string).
        boolean[] isTaken = new boolean[26]; // 'a' to 'z'

        // Count character frequencies
        Map<Character, Integer> charCounts = new TreeMap<>();
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            isTaken[c - 'a'] = true;
        }

        for (Map.Entry<Character, Integer> data: mp.entrySet()) {
            char baseChar = data.getKey();
            int count = data.getValue();

            // We've already implicitly "kept" one instance in `isTaken` during the first pass.
            // So, we need to change `count - 1` instances of `baseChar`.
            for (int i = 0; i < count - 1; i++) {
                int currentCost = 0;
                int chosenIdx = -1;

                // Search for the closest untaken character
                for (int dist = 1; dist < 26; dist++) {
                    int leftCharIdx = (baseChar - 'a' - dist + 26) % 26;
                    int rightCharIdx = (baseChar - 'a' + dist) % 26;

                    if (!isTaken[leftCharIdx]) {
                        chosenIdx = leftCharIdx;
                        currentCost = dist;
                        break;
                    }
                    if (!isTaken[rightCharIdx]) {
                        chosenIdx = rightCharIdx;
                        currentCost = dist;
                        break;
                    }
                }
                totalCost += currentCost;
                isTaken[chosenIdx] = true; // Mark the chosen character as taken
            }
        
        }

        return totalCost;
    }
}