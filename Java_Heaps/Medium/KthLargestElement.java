package Java_Heaps.Medium;

class KthLargestElement {
    public int kthLargestElement(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for(int i = k; i < n; i++) {
            int min = minHeap.peek();

            if(min < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}