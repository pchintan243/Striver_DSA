#include <vector>

void rotateMatrix(vector<vector<int>> &mat)
{
    // Write your code here.
    int n = mat.size();

    // First we transpose the matrix means first row become first column and likewise.
    // After that reverse the row it will give the rotated matrix by 90 degree.
    // outer loop run n-1 times coz last index is diagonal so we don't have to swap it.
    for (int i = 0; i < n - 1; i++)
    {
        // Inner loop start from i + 1 coz previous element is alread swapped.
        for (int j = i + 1; j < n; j++)
        {
            swap(mat[i][j], mat[j][i]);
        }
    }

    for (int i = 0; i < n; i++)
    {
        // It takes mat[i][j-> 0 - n]
        // Reverse the row
        reverse(mat[i].begin(), mat[i].end());
    }
}