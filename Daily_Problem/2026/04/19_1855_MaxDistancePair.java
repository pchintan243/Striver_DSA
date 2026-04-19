package Daily_Problem.2026.04;

public class 19_1855_MaxDistancePair {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int ans = 0;

        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
                j++;
            }
        }
        return ans;
    }
}