bool searchMatrix(vector<vector<int>> &mat, int target)
{
    // size
    int n = mat.size();
    int m = mat[0].size();

    // Take high as last element which is size of arr
    int low = 0;
    int high = n * m - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        // It finds row index
        int row = mid / m;
        // It finds col index
        int col = mid % m;
        if (mat[row][col] == target)
        {
            return true;
        }
        else if (mat[row][col] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return false;
}