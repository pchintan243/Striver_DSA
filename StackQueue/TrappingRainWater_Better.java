class TrappingRainWater_Better {
    int[] findLeftMax(int[] arr) {
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            pre[i] = Math.max(arr[i], pre[i - 1]);
        }
        return pre;
    }
    int[] findRightMax(int[] arr) {
        int n = arr.length;
        int[] suff = new int[n];
        suff[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = Math.max(arr[i], suff[i + 1]);
        }
        return suff;
    }
    public boolean isReverseSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public int trap(int[] height) {
        int n = height.length;
        if(isReverseSorted(height)) 
            return 0;
        int ans = 0;
        int[] prefix = findLeftMax(height);
        int[] suffix = findRightMax(height);
        for(int i = 1; i < n - 1; i++) {
            int left = prefix[i];
            int right = suffix[i];
            if((left > height[i]) && (right > height[i])) {
                int takeMin = Math.min(left, right);
                ans += takeMin - height[i];
            }
        }

        return ans;
    }
}