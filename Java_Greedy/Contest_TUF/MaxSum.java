package Contest_TUF;

import java.util.List;

class MaxSum {
    /**
     * Maximizes the sum of an array by applying two operations:
     * 1. Multiply any prefix by -1.
     * 2. Multiply any suffix by -1.
     *
     * The chosen prefix and suffix may intersect.
     *
     * @param nums A List of integers representing the input array.
     * @return The maximum possible sum of the array after performing the operations.
     */
    public int maxSum(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) {
            return 0;
        }

        // Step 1: Calculate the total sum of the original array.
        long totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        // Step 2: Apply Kadane's algorithm to find the maximum subarray sum.
        // This 'max_subarray_sum' represents the sum of the contiguous segment
        // that will effectively retain its original signs (or be flipped twice).

        // Initialize maxSoFar and currentMax with the first element's value.
        // We use long to prevent potential overflow, as sums can become large.
        long maxSoFar = nums.get(0);
        long currentMax = nums.get(0);

        for (int i = 1; i < n; i++) {
            // Kadane's algorithm:
            // currentMax is either the current element itself, or the current element
            // added to the currentMax from the previous step.
            currentMax = Math.max((long)nums.get(i), currentMax + nums.get(i));
            
            // maxSoFar keeps track of the overall maximum subarray sum found so far.
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // It's crucial to consider the case where the optimal "unflipped" segment is empty.
        // If the best strategy is to flip the entire array, then the 'max_subarray_sum'
        // effectively represents an empty segment with sum 0.
        // So, we take the maximum between the result from Kadane's (maxSoFar) and 0L.
        // This allows for the possibility of flipping the entire array to maximize sum
        // (e.g., if all numbers are negative).
        long max_subarray_sum = Math.max(0L, maxSoFar);


        // Step 3: Calculate the maximum possible sum using the derived formula.
        // Maximum Sum = (2 * sum of the segment that is not net-flipped) - (total sum of original array)
        // We cast the final result to int as the problem's return type is int.
        // Be mindful of potential overflow if the result exceeds Integer.MAX_VALUE.
        return (int)((2 * max_subarray_sum) - totalSum);
    }
}
