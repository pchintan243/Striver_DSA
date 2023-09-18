// We have to find the consecutive elements in an array.

int longestSuccessiveElements(vector<int> &a)
{
    // Write your code here.
    sort(a.begin(), a.end());

    int count = 1;
    int longest = INT_MIN;
    int previous = 1;
    for (int i = 1; i < a.size(); i++)
    {
        previous = a[i - 1];
        if (previous == a[i] - 1)
        {
            count++;
        }
        else if (a[i] != previous)
        {
            count = 1;
            previous = a[i];
        }

        longest = max(longest, count);
    }
    return longest;
}