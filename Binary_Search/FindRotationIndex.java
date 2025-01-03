class FindRotationIndex {
    public int findKRotation(List<Integer> nums) {
        // Code here
        int low = 0;
        int high = nums.size() - 1;
        int ans = Integer.MAX_VALUE;
        int rotation = 0;

        while(low <= high) {
            int mid = (low + high) / 2;

            // if array is sorted 
            if(nums.get(low) <= nums.get(high)) {
                if(ans > nums.get(low)) {
                    ans = nums.get(low);
                    rotation = low;
                }
                break;
            }
            if(nums.get(low) <= nums.get(mid)) {
                if(ans > nums.get(low)) {
                    ans = nums.get(low);
                    rotation = low;
                }
                low = mid + 1;                
            } else {
                if(ans > nums.get(mid)) {
                    ans = nums.get(mid);
                    rotation = mid;
                }
                high = mid - 1;                
            }
        }

        return rotation;
    }
}