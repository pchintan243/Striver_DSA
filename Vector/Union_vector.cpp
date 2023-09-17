#include <set>
vector < int > sortedArray(vector < int > a, vector < int > b) {
    // Write your code here
    int i = 0,j= 0,n=a.size(), m = b.size();
    vector<int> f;
    while(i != n && j != m) {
        if(a[i] <= b[j]) {
            if(f.size() == 0 || f.back() != a[i]) {
                f.push_back(a[i]);
            }
            i++;
        }
        else {
            if(f.size() == 0 || f.back() != b[j]) {
                f.push_back(b[j]);
            }
            j++;
        }
    }

    while(i < n) {
        if (f.size() == 0 || f.back() != a[i]) {
            f.push_back(a[i]);
        }
        i++;
    }
    
    while(j < m) {
        if(f.size() == 0 || f.back() != b[j]) {
            f.push_back(b[j]);
        }
        j++;
    }
    return f;
}
