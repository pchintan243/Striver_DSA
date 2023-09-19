vector<int> spiralMatrix(vector<vector<int>> &mat)
{
    // Write your code here.
    vector<int> ans;
    int n = mat.size();
    int m = mat[0].size();

    int left = 0, right = m - 1;
    int top = 0, bottom = n - 1;

    while (top <= bottom && left <= right)
    {
        for (int i = left; i <= right; i++)
        {
            ans.push_back(mat[top][i]);
        }
        top++;

        for (int i = top; i <= bottom; i++)
        {
            ans.push_back(mat[i][right]);
        }
        right--;
        // It will check if only one row exist then not to print again from right to left because it's already print when first loop execute from left to right.
        if (top <= bottom)
        {
            for (int i = right; i >= left; i--)
            {
                ans.push_back(mat[bottom][i]);
            }
            bottom--;
        }

        // It check in right still have an element.
        if (left <= right)
        {
            for (int i = bottom; i >= top; i--)
            {
                ans.push_back(mat[i][left]);
            }
            left++;
        }
    }
    return ans;
}