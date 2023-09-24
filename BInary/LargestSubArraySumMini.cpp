// Problem: you have to divide your array into given partition and take subarray maximum sum
// After you dividing all posibillities then you have to take minimum of all of them.
int findPair(vector<int> a, int mid)
{

    int count = 1;
    int last = 0;
    for (int i = 0; i < a.size(); i++)
    {
        if (last + a[i] <= mid)
        {
            last += a[i];
        }
        else
        {
            last = a[i];
            count++;
        }
    }
    return count;
}
int largestSubarraySumMinimized(vector<int> a, int k)
{
    // Write Your Code Here
    int n = a.size();
    if (k > n)
        return -1;

    int low = *max_element(a.begin(), a.end());
    int high = accumulate(a.begin(), a.end(), 0);

    while (low <= high)
    {
        int mid = (low + high) / 2;

        int ans = findPair(a, mid);

        if (ans <= k)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return low;
}