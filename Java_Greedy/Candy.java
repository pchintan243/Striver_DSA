import java.io.*;
import java.util.*;

public class Candy {
    public static int candy(int[] ratings) {
        //your code goes here

        int n = ratings.length;

        int ans = 1;
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                ans++;
                i++;
                continue;
            }
            int up = 1;
            while (i < n && ratings[i - 1] < ratings[i]) {
                i++;
                up++;
                ans += up;
            }
            int down = 1;
            while (i < n && ratings[i - 1] > ratings[i]) {
                ans += down;
                i++;
                down++;
            }
            if (down > up) {
                ans += down - up;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(candy(arr));
    }
}

//13
//        1 2 3 8 4 3 2 1 1 1 2 3 2