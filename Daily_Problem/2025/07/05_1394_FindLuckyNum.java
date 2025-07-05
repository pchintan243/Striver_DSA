package Daily_Problem.2025.07;

import java.util.Arrays;

public class 05_1394_FindLuckyNum {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int i = n - 1;
        Arrays.sort(arr);
        while(i >= 0) {
            int num = arr[i];
            int ind = i - num + 1;
            if(ind >= 0 && arr[ind] == num) {
                if(ind - 1 >= 0 && arr[ind - 1] == num) {
                    while(ind >= 0 && arr[ind] == num) {
                        ind--;
                    }
                    i = ind;
                    continue;
                }
                return num;
            }
            i--;
        }

        return -1;
    }
}
