import java.util.ArrayList;
import java.util.List;
class MinHeapMethods {
    List<Integer> lst;
    public void initializeHeap() {
        lst = new ArrayList<>();
    }

    public void insert(int key) {
        int n = lst.size();
        lst.add(key);
        int ind = lst.size() - 1;
        heapifyUp(lst, ind); 
    }

    private void heapifyDown(List<Integer> lst, int n, int i) {
        int smallest = i;
        int leftChildInd = 2 * i + 1;
        int rightChildInd = 2 * i + 2;

        if(leftChildInd < n && lst.get(smallest) > lst.get(leftChildInd)) {
            smallest = leftChildInd;
        }

        if(rightChildInd < n && lst.get(smallest) > lst.get(rightChildInd)) {
            smallest = rightChildInd;
        }

        if(smallest != i) {
            swap(lst, i, smallest);
            heapifyDown(lst, n, smallest);
        }
    }

    private void heapifyUp(List<Integer> lst, int ind) {
        // Continue as long as the current node is not the root (ind > 0)
        // and its value is smaller than its parent's value.
        while (ind > 0 && lst.get(ind) < lst.get((ind - 1) / 2)) {
            int parentInd = (ind - 1) / 2;
            swap(lst, ind, parentInd);
            ind = parentInd;
        }
    }

    private void swap(List<Integer> lst, int a, int b) {
        int temp = lst.get(a);
        lst.set(a, lst.get(b));
        lst.set(b, temp); 
    }

    public void changeKey(int index, int newVal) {
        int oldValue = lst.get(index);

        // 1. Always replace the value at the given index FIRST
        lst.set(index, newVal);

        // 2. Restore the min-heap property based on the comparison with the oldValue
        // If the new value is smaller than the old value, it might need to move up.
        if (newVal < oldValue) {
            heapifyUp(lst, index);
        }
        // If the new value is larger than or equal to the old value, it might need to move down.
        else if(newVal > oldValue) {
            heapifyDown(lst, lst.size(), index);
        }
    }

    public void extractMin() {
        int el = lst.get(0);
        if(lst.size() == 1) {
            lst.remove(0);
        } else {
            swap(lst, 0, lst.size() - 1);
            lst.remove(lst.size() - 1);
            heapifyDown(lst, lst.size(), 0);
        }
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public int getMin() {
       return lst.get(0);
    }

    public int heapSize() {
        return lst.size();
    }
}