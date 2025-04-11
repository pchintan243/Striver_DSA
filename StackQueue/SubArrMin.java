import java.util.Stack;
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        
        // Previous Less Element (PLE)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // -1 -1 1 2
        
        // Next Less Element (NLE)
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        // 1 4 4 4
        
        // Result
        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i]; // 1
            long right = nextLess[i] - i; // 1
            result = (result + arr[i] * left * right) % mod;
        }
        
        return (int) result;
    }
}
