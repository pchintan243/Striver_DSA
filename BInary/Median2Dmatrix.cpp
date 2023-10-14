int upperBound(vector<int> &arr, int x, int n)
{
    // Write your code here.
    int low = 0;
    int high = n - 1;
    int ans = n;
    // Upper bound return the (index+1) of element if found otherwise it return the immediate higher element index.
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] > x)
        {
            ans = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ans;
}

int countSmallEqual(vector<vector<int>> &matrix, int n, int m, int x)
{
    int cnt = 0;
    for (int i = 0; i < n; i++)
    {
        cnt += upperBound(matrix[i], x, m);
    }
    return cnt;
}

int median(vector<vector<int>> &matrix, int m, int n)
{
    // Write your code here.
    int low = INT_MIN;
    int high = INT_MAX;
    n = matrix.size();
    m = matrix[0].size();

    // Take min in first column as low and max in last col as high
    for (int i = 0; i < n; i++)
    {
        low = min(low, matrix[i][0]);
        high = max(high, matrix[i][m - 1]);
    }

    int req = (n * m) / 2;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        int smallEqual = countSmallEqual(matrix, n, m, mid);

        if (smallEqual <= req)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return low;
}