// In this problem we have to find the element which has highest element from all of the right element.

vector<int>
superiorElements(vector<int> &a)
{
    // Write your code here.

    vector<int> v;
    int maxi = INT_MIN;

    for (int i = a.size() - 1; i >= 0; i--)
    {
        if (a[i] > maxi)
        {
            v.push_back(a[i]);
            maxi = max(a[i], maxi);
        }
    }

    sort(v.begin(), v.end());
    return v;
}