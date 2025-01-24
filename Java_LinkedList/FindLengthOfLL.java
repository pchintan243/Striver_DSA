
class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
        if(head == null) {
            return 0;
        }
        int cnt = 1;
        while(head.next != null) {
            cnt++;
            head = head.next;
        }
        
        return cnt;
    }
}