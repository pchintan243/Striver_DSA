class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();

        HashMap<Character, Integer> h = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(h.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            ans.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return ans.toString();

    }
}