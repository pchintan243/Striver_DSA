// koko eats banana
// Problem: you have to eat banana in given hours
// Return the minimum index that koko eats all banana

int func(vector<int> v, int mid)
{
    int countHour = 0;
    // ceil of hour
    // 12 23 45 --Your array
    // mid = 5;
    // ceil = 3 + 5 + 9 = 17

    for (int i = 0; i < v.size(); i++)
    {
        if (v[i] % mid == 0)
        {
            countHour += v[i] / mid;
        }
        else
        {
            countHour += (v[i] / mid) + 1;
        }
    }
    return countHour;
}

int minimumRateToEatBananas(vector<int> v, int h)
{
    // Write Your Code Here
    int n = v.size();
    sort(v.begin(), v.end());
    int low = 1;
    // High pointing max element of the array
    int high = v[n - 1];

    // At the end of the day low is poiniting minimum index
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (h >= func(v, mid))
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