int findMin(vector<int> &arr)
{
    // Write your code here.
    int low = 0;
    int high = arr.size() - 1;
    int minNumber = INT_MAX;
    while (low <= high)
    {
        int mid = (low + high) / 2;

        // If array is sorted then we don't need to iterate over the array
        // low is pointing to smallest element
        if (arr[low] <= arr[high])
        {
            minNumber = min(minNumber, arr[low]);
            break;
        }
        // low value is smaller than mid value then we need to take minimum number who's pointing low.
        if (arr[low] <= arr[mid])
        {
            minNumber = min(minNumber, arr[low]);
            low = mid + 1;
        }
        else
        {
            minNumber = min(minNumber, arr[mid]);
            high = mid - 1;
        }
    }
    return minNumber;
}