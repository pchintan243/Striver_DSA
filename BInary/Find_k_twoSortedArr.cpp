#include <bits/stdc++.h>
int kthElement(vector<int> &a, vector<int> &b, int n1, int n2, int k)
{
    // Write your code here

    // It is same as previous one to find the median in two sorted order
    // If size is higher than we call again and transfer the vector
    if (n1 > n2)
        return kthElement(b, a, n2, n1, k);

    int n = n1 + n2;

    // If arr1->size is 6 & arr2->size is 5 and we have to find 7th element then we need at least 2 element from arr1
    int low = max(k - n2, 0);

    // If arr1->size is 5 and we have to find 2nd element then we need to pick high as max(k, n1)
    int high = min(k, n1);
    int left = k;

    while (low <= high)
    {

        int mid1 = (low + high) / 2;
        int mid2 = left - mid1;
        int l1 = INT_MIN, l2 = INT_MIN;
        int r1 = INT_MAX, r2 = INT_MAX;

        if (mid1 < n1)
            r1 = a[mid1];
        if (mid2 < n2)
            r2 = b[mid2];

        if (mid1 - 1 >= 0)
            l1 = a[mid1 - 1];
        if (mid2 - 1 >= 0)
            l2 = b[mid2 - 1];

        if (l1 <= r2 && l2 <= r1)
        {
            return max(l1, l2);
        }

        else if (l1 > r2)
        {
            high = mid1 - 1;
        }
        else
        {
            low = mid1 + 1;
        }
    }
    return 0;
}