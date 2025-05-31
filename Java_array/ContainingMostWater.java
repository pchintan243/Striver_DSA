class ContainingMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int ans = 0;
        while(l <= r) {
            if(height[l] < height[r]) {
                int temp = height[l] * (r - l);
                ans = Math.max(temp, ans);
                l++;
            } else {
                int temp = height[r] * (r - l);
                ans = Math.max(temp, ans);
                r--;
            }
        }
        return ans;
    }
}
