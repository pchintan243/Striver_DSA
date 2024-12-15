class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                // Return the 1-based index of the word
                return i + 1;
            }
        }
        // Return -1 if no match is found
        return -1;
    }
}