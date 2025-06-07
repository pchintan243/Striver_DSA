import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class 07_3170LexicographyString {
    public String clearStars(String s) {
        Map<Character, List<Integer>> mp = new TreeMap<>();
        int n = s.length();
        char[] ch = s.toCharArray();

        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(ch[i], new ArrayList<>());
            mp.get(ch[i]).add(i);
            if(mp.containsKey('*')) {
                mp.remove('*');
                for(Map.Entry<Character, List<Integer>> data: mp.entrySet()) {
                    data.getValue().remove(data.getValue().size() - 1);
                    if(data.getValue().isEmpty()) {
                        mp.remove(data.getKey());
                    }
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> finalList = new ArrayList<>();
        for(Map.Entry<Character, List<Integer>> data: mp.entrySet()) {
            finalList.addAll(new ArrayList<>(data.getValue()));
        }

        Collections.sort(finalList);
        for(int i: finalList) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}