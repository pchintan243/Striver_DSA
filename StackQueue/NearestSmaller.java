public class NearestSmaller {
    public int[] prevSmaller(int[] n) {
        Stack<Integer> st = new Stack<>();
        
        int[] arr = new int[n.length];
        Arrays.fill(arr, -1);
        for(int i = 0; i < n.length; i++) {
            while(!st.isEmpty() && n[i] <= st.peek()) {
                st.pop();
            }
            arr[i] = st.isEmpty() ? -1 : st.peek();
            st.push(n[i]);
        }
        
        return arr;
    }
}
