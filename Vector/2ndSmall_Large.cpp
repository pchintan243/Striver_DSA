vector<int> getSecondOrderElements(int n, vector<int> a) {
    // Write your code here.
    int smallest = a[0];
    int largest = a[0];
    int sSmallest = 99999;
    int sLargest = -1;

    for(int i = 1; i < n; i++) {
        if(a[i]<smallest) {
            sSmallest = smallest;
            smallest = a[i];
        }
        else if(sSmallest > a[i] && a[i] != smallest) {
            sSmallest =a[i];
        }
        if(a[i] >largest) {
            sLargest = largest;
            largest = a[i];
        }
        else if(a[i]>sLargest && a[i] < largest) {
            sLargest = a[i];
        }
    }
    return {sLargest, sSmallest};
}