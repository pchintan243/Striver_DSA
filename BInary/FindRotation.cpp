#include <bits/stdc++.h>
int findKRotation(vector<int> &arr)
{
    // Write your code here.
    int low = 0;
    int high = arr.size() - 1;
    int minNumber = INT_MAX;
    int index = -1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[low] <= arr[high])
        {
            // if we found the smaller number then we take index of that number
            if (arr[low] < minNumber)
            {
                index = low;
                minNumber = arr[low];
            }
            break;
        }
        if (arr[low] <= arr[mid])
        {
            if (arr[low] < minNumber)
            {
                index = low;
                minNumber = arr[low];
            }
            low = mid + 1;
        }
        else
        {
            if (arr[mid] < minNumber)
            {
                index = mid;
                minNumber = arr[mid];
            }
            high = mid - 1;
        }
    }
    return index;
}