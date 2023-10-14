// Find max element in column
// Return the index of max element
int findMaxIndex(vector<vector<int>> &g, int n, int m, int col)
{
    int maxValue = -1;
    int index = -1;

    for (int i = 0; i < n; i++)
    {
        if (g[i][col] > maxValue)
        {
            maxValue = g[i][col];
            index = i;
        }
    }
    return index;
}
vector<int> findPeakGrid(vector<vector<int>> &g)
{
    // Write your code here.
    int n = g.size();
    int m = g[0].size();
    int low = 0;
    int high = m - 1;

    while (low <= high)
    {
        int mid = (low + high) / 2;
        int maxRowIndex = findMaxIndex(g, n, m, mid);

        // Left pointing previous element of mid and right pointing next element of mid in row.
        int left = mid - 1 >= 0 ? g[maxRowIndex][mid - 1] : -1;
        int right = mid + 1 < m ? g[maxRowIndex][mid + 1] : -1;

        // If left and right are smaller than mid element then it is our peak element we need to simply return the index of that
        if (g[maxRowIndex][mid] > left && g[maxRowIndex][mid] > right)
        {
            return {maxRowIndex, mid};
        }
        else if (g[maxRowIndex][mid] < left)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return {-1, -1};
}