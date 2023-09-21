bool searchInARotatedSortedArrayII(vector<int> &arr, int k)
{
    // Write your code here.
    int n = arr.size();
    // return true if element found otherwise false
    // it is similar to part one only difference is we need to return the boolean value instead of index.
    int low = 0;
    int high = n - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] == k)
            return 1;
        else if (arr[low] <= arr[mid])
        {
            if (arr[low] <= k && k <= arr[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        else
        {
            if (arr[mid] <= k && k <= arr[high])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
    }
    return 0;
}
