package Medium;
import java.util.ArrayList;
import java.util.List;

public class 89_GrayCode {
    public List<Integer> grayCode(int n) {
        n = 1 << n;
        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            lst.add(i ^ (i >> 1));
        }
        return lst;
    }
}