class MinHeap {

    /**
     * Swaps two elements in the array.
     *
     * @param nums The array.
     * @param a    Index of the first element.
     * @param b    Index of the second element.
     */
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * Restores the min-heap property by moving an element at 'ind' downwards.
     * This is used when an element is larger than its children, violating the min-heap property.
     *
     * @param nums The array representing the min-heap.
     * @param n    The current size of the heap (number of active elements).
     * @param ind  The index of the element to heapify down.
     */
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

    /**
     * Restores the min-heap property by moving an element at 'ind' upwards.
     * This is used when an element is smaller than its parent, violating the min-heap property.
     * Using an iterative approach is generally more efficient and avoids stack overflow.
     *
     * @param nums The array representing the min-heap.
     * @param ind  The index of the element to heapify up.
     */
    private void heapifyUp(int[] nums, int ind) {
        // Continue as long as the current node is not the root (ind > 0)
        // and its value is smaller than its parent's value.
        while (ind > 0 && nums[ind] < nums[(ind - 1) / 2]) {
            int parentInd = (ind - 1) / 2;
            swap(nums, ind, parentInd); // Use the helper swap method
            // Move up to the parent's position
            ind = parentInd;
        }
    }

    /**
     * Replaces the value at a given index in a min-heap and then restores
     * the min-heap property. It determines whether to perform a heapifyUp
     * or heapifyDown operation based on the new value compared to the old value.
     *
     * @param nums The array representing the min-heap.
     * @param ind  The index where the value needs to be replaced.
     * @param val  The new value to be placed at 'ind'.
     * @return The modified array with the min-heap property restored.
     */
    public int[] heapify(int[] nums, int ind, int val) {
        // Store the old value at the index to determine if we need to heapify up or down
        int oldValue = nums[ind];

        // 1. Always replace the value at the given index FIRST
        nums[ind] = val;

        // 2. Restore the min-heap property based on the comparison with the oldValue
        // If the new value is smaller than the old value, it might need to move up.
        if (val < oldValue) {
            heapifyUp(nums, ind);
        }
        // If the new value is larger than or equal to the old value, it might need to move down.
        else {
            heapifyDown(nums, nums.length, ind);
        }

        return nums; // Return the modified array
    }
}
