import java.util.ArrayList;

public class Missing_Repeating_Number {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        long n = arr.length;
        long sn = (n * (n + 1)) / 2;
        long sn2 = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0;
        long s2 = 0;
        for (int i = 0; i < n; i++) {
            s += (long) arr[i];
            s2 += (long) arr[i] * (long) arr[i];
        }

        long val1 = s - sn;
        long val2 = s2 - sn2;
        val2 = val2 / val1;
        int x = (int) ((val1 + val2) / 2);
        int y = (int) (x - val1);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(x);
        res.add(y);

        return res;
    }
}
