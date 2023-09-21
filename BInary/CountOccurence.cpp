// Lower bound case
int lower(vector<int> &arr, int n, int k)
{
    int low = 0;
    int high = n - 1;
    int firstOccur = -1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] == k)
        {
            high = mid - 1;
            firstOccur = mid;
        }
        else if (arr[mid] > k)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return firstOccur;
}

// Upper bound case
int upper(vector<int> &arr, int n, int k)
{
    int low = 0;
    int high = n - 1;
    int lastOccur = -1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] == k)
        {
            lastOccur = mid;
            low = mid + 1;
        }
        else if (arr[mid] > k)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return lastOccur;
}

int count(vector<int> &arr, int n, int k)
{
    // Write Your Code Here
    int firstOccur = lower(arr, n, k);

    // If number is not found then we don't need to find last occurence because it not exist
    if (firstOccur == -1)
        return 0;

    int lastOccur = upper(arr, n, k);

    // subtract first occurence from last ocuurence and add one to it.
    return lastOccur - firstOccur + 1;
}
