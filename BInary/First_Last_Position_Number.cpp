// 1 2 3 3 3 3 3 4 5 5 6 7
// Our answer is

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

pair<int, int> firstAndLastPosition(vector<int> &arr, int n, int k)
{
    // Write your code here
    int firstOccur = lower(arr, n, k);

    // If number is not found then we don't need to find last ocuurence because it not exist
    if (firstOccur == -1)
        return {-1, -1};

    int lastOccur = upper(arr, n, k);

    return {firstOccur, lastOccur};
}
