int searchInsert(vector<int> &arr, int m)
{
    // Write your code here.
    int n = arr.size();
    int low = 0;
    int high = n - 1;
    int ans = n;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        // It same as lower bound
        // If we found the element then we return the index of an element.
        // If we not found then we return the immediate higher number index.
        // Because is this only position where we insert the number in sorted form.

        if (arr[mid] >= m)
        {
            ans = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ans;
}