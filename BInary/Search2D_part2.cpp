bool searchElement(vector<vector<int>> &MATRIX, int target)
{
    // Write your code here.
    int n = MATRIX.size();
    int m = MATRIX[0].size();
    int row = 0;
    int col = m - 1;

    while (row < n && col >= 0)
    {
        if (target == MATRIX[row][col])
        {
            return 1;
        }
        else if (target < MATRIX[row][col])
        {
            col--;
        }
        else
        {
            row++;
        }
    }
    return 0;
}