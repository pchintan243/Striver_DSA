public class isMinHeap {
    public boolean isHeap(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1 / 2; i++) {
            int firstChild = 2 * i + 1;
            int secondChild = 2 * i + 2;
            if(firstChild < n && nums[firstChild] < nums[i]) {
                return false;
            }
            if(secondChild < n && nums[secondChild] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}