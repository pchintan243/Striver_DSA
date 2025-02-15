class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(s.isEmpty())
            return s;
        int temp = s.pop();
        sort(s);
        s = insertNode(s, temp);
        return s;
    }
    
    public Stack<Integer> insertNode(Stack<Integer> s, int temp) {
        
        if(s.isEmpty() || s.peek() <= temp) {
            s.push(temp);
            return s;
        }
        
        int top = s.pop();
        insertNode(s, temp);
        s.push(top);
        return s;
    }
}