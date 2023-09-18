vector<int> alternateNumbers(vector<int>&a) {
    // Write your code here.
    int pos = 0;
    int neg = 1;
    vector<int> v(a.size(),0);
    for(int i = 0; i < a.size(); i++) {
        if(a[i] > 0) {
            v[pos] = a[i];
            pos += 2;
        }
        else {
            v[neg] = a[i];
            neg += 2;
        }
    }
    return v;
}