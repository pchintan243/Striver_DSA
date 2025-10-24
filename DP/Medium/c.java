package Medium;

class ClimbingStairs {
    public int climbStairs(int n) {
        int prev = 1;
        int prev2 = 1;
        while(n-- > 1) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}