package Java_Greedy;

public class LemonadeChange {
    static public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;
        for(int b: bills) {
            if(b == 5) {
                cnt5++;
            } else if(b == 10) {
                if(cnt5 == 0) {
                    return false;
                }
                cnt5--;
                cnt10++;
            } else {
                if(cnt10 == 0) {
                    if(cnt5 >= 3) {
                        cnt5 -= 2;
                    } else {
                        return false;
                    }
                } else {
                    cnt10--;
                }
                if(cnt5 == 0) {
                    return false;
                } else {
                    cnt5--;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] g = new int[]{5,5,5,10,10,20};
        System.out.println(lemonadeChange(g));
    }

}