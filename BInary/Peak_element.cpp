int findPeakElement(vector<int> &arr)
{
    // Write your code here
    int n = arr.size();

    // If arr size is 0 return 0;
    if (n == 0)
        return 0;

    // Manually check for first and last element.
    if (arr[0] > arr[1])
        return 0;
    if (arr[n - 1] > arr[n - 2])
        return n - 1;

    int low = 1;
    int high = n - 2;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        // If mid element is higher than it's previous and next element then it's your peak element.
        if ((arr[mid] > arr[mid + 1]) && (arr[mid] > arr[mid - 1]))
        {
            return mid;
        }
        // If your mid element is higher than it's previus element then one of the peak element lies on right portion
        else if (arr[mid] > arr[mid - 1])
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return -1;
}
