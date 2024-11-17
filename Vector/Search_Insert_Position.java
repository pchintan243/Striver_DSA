class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            int mid = (i + j) / 2;
            if(nums[mid] == target) {
                i = mid;
                break;
            }
            else if(nums[mid] > target) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    }
}