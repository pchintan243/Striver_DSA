class 10_2918_MinEqualSum {
    public long minSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int cnt1 = 0;
        int cnt2 = 0;
        
        long sum1 = 0;
        long sum2 = 0;

        for(int i = 0; i < n1; i++) {
            sum1 += nums1[i];
            if(nums1[i] == 0) {
                cnt1++;
            }
        }
        for(int i = 0; i < n2; i++) {
            sum2 += nums2[i];
            if(nums2[i] == 0) {
                cnt2++;
            }
        }
        if(cnt1 == 0 && cnt2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        } else if(cnt1 == 0 && cnt2 != 0) {
            return sum2 + cnt2 <= sum1 ? sum1 : -1;
        } else if(cnt1 != 0 && cnt2 == 0) {
            return sum1 + cnt1 <= sum2 ? sum2 : -1;
        }
        // System.out.println(sum1 + " " + sum2);
        // System.out.println(cnt1 + " " + cnt2);
        if(sum1 == sum2) {
            return sum1 + Math.max(cnt1, cnt2);
        }
        if(cnt1 == cnt2) {
            return Math.max(sum1, sum2) + cnt1;
        } else if(cnt1 > cnt2) {
            if(Math.abs(sum2 - sum1) >= Math.abs(cnt1 - cnt2)) {
                if(sum1 > sum2) {
                    return sum1 + cnt1;
                } else {
                    return sum2 + cnt2;
                }
            } else {
                return Math.min(sum1, sum2) + Math.max(cnt1, cnt2);
            }
        } else {
            if(sum1 > sum2) {
                return sum1 + cnt1;
            } else {
                return sum2 + cnt2;
            }
        }
    }
}