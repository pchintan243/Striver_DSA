import java.util.ArrayList;
import java.util.List;
class 08_386_LexicographyNumber {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        int cnt = 1;
        for(int i = 0; i < n; i++) {
            ans.add(cnt);

            if(cnt * 10 <= n) {
                cnt *= 10;
            } else {
                if(cnt >= n)
                    cnt /= 10;
                cnt++;
                while(cnt % 10 == 0)
                    cnt /= 10;
            }
        }
        
        return ans;
    }
}