class TrappingRainWater_Optimal {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        while(left < right) {
            if(leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
            }
        }

        return ans;
    }
}