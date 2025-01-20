class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();

        String[] words = sb.toString().split(" ");

        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                ans.append(new StringBuilder(word).reverse()).append(" ");
            }
        }

        return ans.toString().trim();
    }
}