
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        if(head == null) {
            return false;
        }
        
        while(head != null) {
            if(key == head.data) {
                return true;
            }
            head = head.next;
        }
        
        return false;
    }
}