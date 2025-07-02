class 3335_ArrayTransformation {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        // Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        int qn = queries.length;

        // Step 1: Create a Difference Array of size n+1 (to handle end + 1 index)
        int[] diff = new int[n + 1]; // Initialize with zeros by default

        // Step 2: Process Queries using the Difference Array
        // O(qn) operations
        for (int i = 0; i < qn; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            diff[start]++; // Increment at the start of the range
            if (end + 1 <= n) { // If end+1 is within bounds, decrement there
                diff[end + 1]--;
            }
        }

        // Step 3: Compute actual decrements and apply to nums
        // O(n) operations
        int currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i]; // Accumulate the net effect of queries up to this point
            nums[i] -= currentDecrement; // Apply the total decrement

            // Step 4: Check if any element remains positive
            if (nums[i] > 0) {
                return false; // If any element is still positive, it's not a zero array
            }
        }

        // If all elements are 0 or negative, it's considered a "zero array" as per problem
        // "if(nums[i] > 0) { return false; }" implies nums[i] <= 0 is true.
        return true;
    }
}