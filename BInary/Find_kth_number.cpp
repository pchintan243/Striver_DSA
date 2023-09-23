int missingK(vector<int> vec, int n, int k)
{
    // Write your code here.

    int low = 0;
    int high = n - 1;

    while (low <= high)
    {
        int mid = (low + high) / 2;

        // Find missing number number at mid pointing  - index of mid - 1
        int missingNum = vec[mid] - mid - 1;

        if (missingNum >= k)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }

    // At the end of the day high is pointing to before low index that's why loops break
    // We know low = high + 1
    return low + k;
}
