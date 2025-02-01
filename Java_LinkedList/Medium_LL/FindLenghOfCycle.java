class FindLengthOfCycle {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        if(head == null || head.next == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                int cnt = 1;
                fast = fast.next;
                while(slow != fast) {
                    cnt++;
                    fast = fast.next;
                }
                return cnt;
            }
        }
        return 0;
    }
}