pair<int, int> getFloorAndCeil(int arr[], int n, int x)
{
    // Write your code here.
    int low = 0;
    int high = n - 1;
    int floor = -1;
    int ceil = -1;
    vector<int> v;

    // floor condition
    // we need to find lower bound on that number & return the number of lower bound index

    for (int i = 0; i < n; i++)
    {
        v.push_back(arr[i]);
    }

    sort(v.begin(), v.end());

    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (v[mid] <= x)
        {
            floor = v[mid];
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }

    low = 0;
    high = n - 1;

    // ceil condition
    // we need to find upper bound on that number & return the number of upper bound index
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (v[mid] >= x)
        {
            ceil = v[mid];
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return {floor, ceil};
}
