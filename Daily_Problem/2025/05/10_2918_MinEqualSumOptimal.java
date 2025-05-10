class 10_2918_MinEqualSumOptimal {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zeroCount1 = 0;

        for (int n: nums1) {
            sum1 += n;
            zeroCount1 += n == 0 ? 1 : 0;
        }

        long sum2 = 0;
        int zeroCount2 = 0;

        for (int n: nums2) {
            sum2 += n;
            zeroCount2 += n == 0 ? 1 : 0;
        }

        sum1 += zeroCount1;
        sum2 += zeroCount2;

        if (sum1 < sum2 && zeroCount1 == 0) {
            return -1;
        }

        if (sum1 > sum2 && zeroCount2 == 0) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}