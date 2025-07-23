package Java_Heaps.Medium;

public class HeapSort {
    public void heapSort(int[] nums) {
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapifyDown(nums, 0, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void heapifyDown(int[] nums, int ind, int n) {
        int leftChildInd = ind * 2 + 1;
        int rightChildInd = ind * 2 + 2;
        int highestInd = ind;

        if(leftChildInd < n && nums[leftChildInd] > nums[highestInd]) {
            highestInd = leftChildInd;
        }

        if(rightChildInd < n && nums[rightChildInd] > nums[highestInd]) {
            highestInd = rightChildInd;
        }

        if(highestInd != ind) {
            swap(nums, ind, highestInd);
            heapifyDown(nums, highestInd, n);
        }
    }
}