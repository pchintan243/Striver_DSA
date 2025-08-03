/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to handle the new head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // `current` pointer will track the node before the pair to be swapped
        ListNode current = dummy;
        
        // The loop continues as long as there is a pair to swap
        while (current.next != null && current.next.next != null) {
            
            // `first` and `second` are the nodes in the pair to be swapped
            ListNode first = current.next;
            ListNode second = current.next.next;
            
            // Perform the swap
            first.next = second.next;   // 1. The original first node points to the rest of the list
            second.next = first;        // 2. The original second node points back to the first
            current.next = second;      // 3. The node before the pair now points to the new head of the pair
            
            // Move the `current` pointer two steps forward to the end of the swapped pair
            current = current.next.next;
        }
        
        // The new head is the node after the dummy node
        return dummy.next;
    }
}