class CountOccurence {
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

        return low;
    }

    int countFreq(int[] nums, int target) {
        // code here
        int first = -1;
        int last = -1;

        first = lowerBound(nums, target);

        if(first == -1) {
            return 0;
        } else {
            last = upperBound(nums, target);
        }
        return last - first;
    }
}