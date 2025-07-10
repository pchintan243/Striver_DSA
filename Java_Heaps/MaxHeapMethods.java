import java.util.ArrayList;
import java.util.List;
public class MaxHeapMethods {
    List<Integer> lst;
    public void initializeHeap() {
        lst = new ArrayList<>();
    }

    public void insert(int key) {
        lst.add(key);
        heapifyUp(lst, lst.size() - 1);
    }

    public void changeKey(int index, int newVal) {
        int oldValue = lst.get(index);

        lst.set(index, newVal);
        if(newVal > oldValue) {
            heapifyUp(lst, index);
        } else if(newVal < oldValue) {
            heapifyDown(lst, index, lst.size());
        }
    }

    public void extractMax() {
        if(lst.size() == 1) {
            lst.remove(0);
        } else {
            swap(lst, 0, lst.size() - 1);
            lst.remove(lst.size() - 1);
            heapifyDown(lst, 0, lst.size());
        }
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public int getMax() {
       return lst.get(0);
    }

    public int heapSize() {
        return lst.size();
    }

    private void heapifyUp(List<Integer> lst, int ind) {
        while(ind >= 0 && lst.get(ind) > lst.get((ind - 1) / 2)) {
            swap(lst, ind, (ind - 1) / 2);
            ind = (ind - 1) / 2;
        }
    }

    private void heapifyDown(List<Integer> lst, int ind, int n) {
        int highest = ind;
        int leftChildInd = 2 * ind + 1;
        int rightChildInd = 2 * ind + 2;

        if(leftChildInd < n && lst.get(leftChildInd) > lst.get(highest)) {
            highest = leftChildInd;
        }

        if(rightChildInd < n && lst.get(rightChildInd) > lst.get(highest)) {
            highest = rightChildInd;
        }

        if(ind != highest) {
            swap(lst, ind, highest);
            heapifyDown(lst, highest, n);
        }
    }

    private void swap(List<Integer> lst, int a, int b) {
        int temp = lst.get(a);
        lst.set(a, lst.get(b));
        lst.set(b, temp); 
    }
}
