package Daily_Problem.2025.06;

class 26_2311_LongestSubSequence {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        long value = 0;
        int position = 0; // Position from the right (0-indexed)

        // Traverse from right to left (least significant bit to most)
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                count++;  // Always include 0
                position++; // Move to next position
            } else {
                // Calculate the value of this 1 at current position
                // Avoid overflow by checking if position >= 31 (since k is int)
                if (position >= 31) {
                    // If position is too high, this 1 would definitely exceed k
                    position++;
                    continue;
                }

                long power = 1L << position;

                // Only include this 1 if it doesn't exceed k
                if (value + power <= k) {
                    value += power;
                    count++;
                }
                position++; // Move to next position regardless
            }
        }

        return count;
    }
}