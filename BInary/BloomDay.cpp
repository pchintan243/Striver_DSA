// Find min number from array for low
int minNumber(vector<int> arr)
{
    int ans = INT_MAX;
    for (int i = 0; i < arr.size(); i++)
    {
        ans = min(ans, arr[i]);
    }
    return ans;
}

// Find max number from array for high
int maxNumber(vector<int> arr)
{
    int ans = INT_MIN;
    for (int i = 0; i < arr.size(); i++)
    {
        ans = max(ans, arr[i]);
    }
    return ans;
}

// Count blooming day
int bloomDayCount(vector<int> arr, int k, int mid)
{
    int day = 0;
    int ans = 0;

    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] <= mid)
        {
            day++;
        }
        else
        {
            ans += day / k;
            day = 0;
        }
    }
    ans += day / k;
    return ans;
}

int roseGarden(vector<int> arr, int k, int m)
{
    // Write your code here

    // k is the size of bouquet
    // m is the how much bouquet are required
    if (k * m > arr.size())
        return -1;
    int low = minNumber(arr);
    int high = maxNumber(arr);
    // At the end of the day low is pointing minimum number days.
    while (low <= high)
    {
        int mid = (low + high) / 2;
        int ans = bloomDayCount(arr, k, mid);
        // If bouquet is found then we have to decrease it and check still minimum number of days are exist or not
        if (m <= ans)
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