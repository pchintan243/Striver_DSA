int search(vector<int> &arr, int n, int k)
{
    // Write your code here.
    // Return the position of K in ARR else return -1.
    int low = 0;
    int high = n - 1;
    // If you observe any part must be sorted either it would be low to mid or either it would be mid to high
    while (low <= high)
    {
        int mid = (low + high) / 2;
        // If found return index
        if (arr[mid] == k)
            return mid;
        // If low to mid would be sorted
        else if (arr[low] <= arr[mid])
        {
            // If our target is low < K < mid then our target is in low to mid-1 part.
            // otherwise mid+1 to high part
            if (arr[low] <= k && k <= arr[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        // If low is higher than mid
        else
        {
            // If our target lies between mid < k < high
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
    return -1;
}
