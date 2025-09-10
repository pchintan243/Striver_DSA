import java.util.ArrayList;
import java.util.List;
public class EncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()) {
            return List.of();
        }
        char[] ch = str.toCharArray();
        List<String> ans = new ArrayList<>();
        int i = 0;
        int n = ch.length;

        while(i < n) {
            StringBuilder temp = new StringBuilder();
            while(ch[i] != '#') {
                temp.append(ch[i++]);
            }
            i++;
            int size = Integer.parseInt(temp.toString());
            ans.add(str.substring(i, i + size));

            i += size;
        }
        return ans;
    }
}
