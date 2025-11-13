package Daily_Problem.2025.11;

public class 12_2654_MakeAllOne {
    int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        // Step 1: Check for existing 1s.
        int onesCount = 0;
        for (int num : nums) {
            if (num == 1) {
                onesCount++;
            }
        }
        // If 1s already exist, we just need to spread them.
        // Each existing 1 saves us one operation.
        if (onesCount > 0) {
            return n - onesCount;
        }

        // Step 2: No 1s exist. We must find the *shortest* subarray
        // that can be reduced to 1.
        int minSubarrayLength = Integer.MAX_VALUE;

        // Iterate through all possible subarray start points
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            
            // Find the GCD of subarray [i...j]
            for (int j = i + 1; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                
                if (currentGcd == 1) {
                    // We found a subarray [i...j] whose GCD is 1.
                    // The length is (j - i + 1)
                    int subarrayLength = (j - i + 1);
                    minSubarrayLength = Math.min(minSubarrayLength, subarrayLength);
                    // We found the shortest subarray *starting* at i,
                    // so we can break this inner loop.
                    break;
                }
            }
        }
        // Step 3: Analyze the result.
        if (minSubarrayLength == Integer.MAX_VALUE) {
            // If we never found a subarray with GCD = 1, it's impossible.
            return -1;
        }
        
        // We found a shortest subarray of length 'minSubarrayLength'.
        // Ops to create the first 1 = minSubarrayLength - 1
        // Ops to spread that 1 to the other (n - 1) elements = n - 1
        // Total = (minSubarrayLength - 1) + (n - 1)
        return minSubarrayLength + n - 2;
    }
}