class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length - 1;

        if(n == 0 || nums[0] != nums[1]) {
            return nums[0];
        } else if(nums[n] != nums[n - 1]) {
            return nums[n];
        }

        int low = 1;
        int high = n - 2;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if((mid % 2 == 0) && (nums[mid] == nums[mid + 1]) || 
            (mid % 2 == 1) && (nums[mid] == nums[mid - 1])) {
                low = mid + 1;
                
            } else {
                high = mid - 1;
            }
            
        }

        return -1;
    }
}