class Solution {
    static Node constructLL(int arr[]) {
        // code here
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        
        return head;
    }
}
