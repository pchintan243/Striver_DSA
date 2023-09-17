#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> v = {1, 1, 4, 6, 0, 1, 1, 1, 1, 2, 0, 0, 3};
    int k = 6;

    // Two pointer approach for summation and subtraction.

    int sum = v[0]; // make sure it initialize by first value.
    int len = 0;
    int left = 0, right = 0;
    int n = v.size();

    while (right < n)
    {
        // If sum is higher than target then subtract from first index till to we get less than or equal value to target & increase the left pointer.
        while (sum > k && left <= right)
        {
            sum -= v[left];
            left++;
        }

        // Find length
        if (sum == k)
        {
            len = max(len, right - left + 1);
        }

        // Increase the right pointer before the add summation because initially we takes first index.
        right++;
        if (right < n)
        {
            sum += v[right];
        }
    }

    cout << len << endl;
    return 0;
}