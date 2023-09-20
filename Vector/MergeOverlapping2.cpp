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
        // If its is empty then push it
        // If previous end is lower than current start then push it
        if (ans.empty() || arr[i][0] > ans.back()[1])
        {
            ans.push_back(arr[i]);
        }
        // logic for replace the higher end
        else
        {
            ans.back()[1] = max(ans.back()[1], arr[i][1]);
        }
    }
    return ans;
}