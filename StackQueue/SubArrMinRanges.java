import java.util.Stack;
class SubArrMinRanges {
    void computePreSmall(int[] nums, int n, int[] pre) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            pre[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    void computeNextSmall(int[] nums, int n, int[] next) {
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    void computePreHigh(int[] nums, int n, int[] pre) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            pre[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    void computeNextHigh(int[] nums, int n, int[] next) {
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    long computeHighestSum(int[] nums, int n) {
        long sum = 0;
        int[] pre = new int[n];
        int[] next = new int[n];
        computePreHigh(nums, n, pre);
        computeNextHigh(nums, n, next);
        for(int i = 0; i < n; i++) {
            int left = i - pre[i];
            int right = next[i] - i;
            sum += (long) left * (long) right * (long) nums[i];

        }

        return sum;
    }

    long computeSmallestSum(int[] nums, int n) {
        long sum = 0;
        int[] pre = new int[n];
        int[] next = new int[n];

        computePreSmall(nums, n, pre);
        computeNextSmall(nums, n, next);

        for(int i = 0; i < n; i++) {
            int left = i - pre[i];
            int right = next[i] - i;
            sum += (long) left * (long) right * (long) nums[i];
        }

        return sum;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return computeHighestSum(nums, n) - computeSmallestSum(nums, n);
    }
}