// Brute force approach

#include <vector>

vector<vector<int>> mergeOverlappingIntervals(vector<vector<int>> &arr)
{
    // Write your code here.
    // For storing the pair
    vector<vector<int>> ans;
    int n = arr.size();
    // If it is not sorted then you have to sort it first of all
    // In this case it is already sorted so we don't need to sort it again
    // sort(arr.begin(), arr.end());
    for (int i = 0; i < n; i++)
    {
        // First element of pair
        // Second element of pair
        int start = arr[i][0];
        int end = arr[i][1];

        // If our ans vector is not empty and our end is lower than ans vector of previous element
        // It helps to decrease the iteration.
        // Because end is already lower than which we store then we don't need to iterate over the eniter pair
        if (!ans.empty() && end <= ans.back()[1])
        {
            continue;
        }

        for (int j = i + 1; j < n; j++)
        {
            if (arr[j][0] <= end)
            {
                // Max found higher than than update it
                end = max(end, arr[j][1]);
            }
            else
            {
                break;
            }
        }
        ans.push_back({start, end});
    }
    return ans;
}