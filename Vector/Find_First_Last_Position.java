class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        if(nums != null) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == target) {
                    if(arr[0] == -1)
                        arr[0] = i;
                    arr[1] = i;
                }
            }
            return arr;
        }
        return new int[] {-1, -1};
    }
}