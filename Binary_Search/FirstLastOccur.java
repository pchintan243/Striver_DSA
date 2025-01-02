class FirstLastOccur {
    int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return first;
    }

    int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        first = lowerBound(nums, target);

        if(first == -1) {
            return new int[] {-1, -1};
        } else {
            last = upperBound(nums, target);
        }
        return new int[] {first, last};
    }
}