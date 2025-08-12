package Java_Heaps.Medium;

class KthLargestIntution {
    PriorityQueue<Integer> minHeap;
    int kData;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        kData = k;
        int n = nums.length;
        for(int i = 0; i < Math.min(k, n); i++) {
            minHeap.offer(nums[i]);
        }

        for(int i = k; i < n; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(kData > minHeap.size()) {
            minHeap.offer(val);
            return minHeap.peek();
        }
        if(minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}