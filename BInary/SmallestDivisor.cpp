// Problem: divide all number with any number and take ceil of that number and return the sum of the all number.
// Return smallest divisor which is less than or equal to limit

// Find sum of all number
int smallDiv(vector<int> &arr, int mid)
{
    int ans = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] % mid == 0)
        {
            ans += arr[i] / mid;
        }
        else
        {
            ans += (arr[i] / mid) + 1;
        }
    }
    return ans;
}
int smallestDivisor(vector<int> &arr, int limit)
{
    // Write your code here.
    int n = arr.size();

    if (n > limit)
        return -1;

    int low = 1;
    int high = *max_element(arr.begin(), arr.end());

    for (int i = 0; i < arr.size(); i++)
    {
        high = max(high, arr[i]);
    }

    while (low <= high)
    {
        int mid = (low + high) / 2;
        int ans = smallDiv(arr, mid);
        // If number is found then we don't need to move upword direction so we take high = mid - 1
        // at the end of the day low is pointing your smallest divisor.
        if (ans <= limit)
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