class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        if(arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        // Node temp = head;
        head.prev = null;
        Node tempNode = head;
        for(int i = 1; i < arr.length; i++) {
            // System.out.println(i);
            Node temp = new Node(arr[i]);
            tempNode.next = temp;
            temp.prev = tempNode;
            tempNode = temp;
        }
        
        return head;
    }
}