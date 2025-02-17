class ReverseStack
{ 
    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        // add your code here
        int temp = s.pop();
        reverse(s);
        insertStack(s, temp);
        
    }
    static void insertStack(Stack<Integer> s, int temp) {
        if(s.isEmpty()) {
            s.push(temp);
            return;
        }
        int item = s.pop();
        insertStack(s, temp);
        s.push(item);
        
    }
}