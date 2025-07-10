public class MinHeapToMaxHeap {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for(int i = (n - 1) / 2; i >= 0; i--) {
            heapifyDown(nums, i, n);
        }

        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void heapifyDown(int[] nums, int ind, int n) {
        int highest = ind;
        int leftChildInd = 2 * ind + 1;
        int rightChildInd = 2 * ind + 2;

        if(leftChildInd < n && nums[leftChildInd] > nums[highest]) {
            highest = leftChildInd;
        }

        if(rightChildInd < n && nums[rightChildInd] > nums[highest]) {
            highest = rightChildInd;
        }

        if(ind != highest) {
            swap(nums, ind, highest);
            heapifyDown(nums, highest, n);
        }
    }
}