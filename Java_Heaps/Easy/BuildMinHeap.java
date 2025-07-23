package Java_Heaps;

public class BuildMinHeap {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;

        for(int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, n, i);
        }
    }

    private void heapifyDown(int[] nums, int n, int ind) {
        int smallest = ind; // Initialize smallest as root
        int leftChild = 2 * ind + 1; // Left child index
        int rightChild = 2 * ind + 2; // Right child index

        // If left child is smaller than current smallest
        if (leftChild < n && nums[leftChild] < nums[smallest]) {
            smallest = leftChild;
        }

        // If right child is smaller than current smallest
        if (rightChild < n && nums[rightChild] < nums[smallest]) {
            smallest = rightChild;
        }

        // If smallest is not root, swap and continue heapifying down
        if (smallest != ind) {
            swap(nums, ind, smallest); // Use the helper swap method
            // Recursively call heapifyDown on the affected subtree
            heapifyDown(nums, n, smallest);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}