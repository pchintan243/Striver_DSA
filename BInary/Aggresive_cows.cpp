bool canWePlaceCow(vector<int> &stalls, int distance, int k)
{
    int cntCows = 1;
    // Take initially first cow is pointing first index.
    int last = stalls[0];

    for (int i = 1; i < stalls.size(); i++)
    {
        // If it maintain the distance after subtracting current index to last index then we can able to put the cow on that index and now last index would be where you point now & increase the cowscount by 1
        if (stalls[i] - last >= distance)
        {
            cntCows++;
            last = stalls[i];
        }
        // If number cows are placed in position then we need to return true because condition satisfies
        if (cntCows >= k)
            return true;
    }
    return false;
}

int aggressiveCows(vector<int> &stalls, int k)
{
    //    Write your code here.

    int n = stalls.size();
    sort(stalls.begin(), stalls.end());

    int low = 0;
    // Take high as last index - first index --> max number - min number
    int high = stalls[n - 1] - stalls[0];

    while (low <= high)
    {
        int mid = (low + high) / 2;
        // Cow place is possible or not check
        if (canWePlaceCow(stalls, mid, k))
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }

    return high;
}