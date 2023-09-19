vector<int> ncr(int k)
{
    vector<int> ans;
    long long n = 1;
    // Every element has first element as 1 so pushback 1;
    ans.push_back(1);
    // NcR logic
    for (int i = 0; i < k; i++)
    {
        n *= (k - i);
        n /= (i + 1);
        ans.push_back(n);
    }
    // Return the vector
    return ans;
}
vector<vector<int>> pascalTriangle(int N)
{
    // Write your code here.

    // Take one 2D vector for storing the element.
    vector<vector<int>> v;
    for (int i = 0; i < N; i++)
    {
        // Push the entire row
        v.push_back(ncr(i));
    }
    return v;
}