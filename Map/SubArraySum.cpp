#include <bits/stdc++.h>
using namespace std;

int main()
{
    // Also it is optimal solution when vector has a negative numbers. But not for positive only.
    // This code is working fine for negative numbers are there in the list.
    // It might be TLE if all of the numbers are positive in nature.
    vector<int> v = {1, 1, 2, 3, 2, 1, 1, 4, 6, 0, 1, 1, 1, 1, 2, 0, 3};
    int k = 6;
    map<long long, int> mp;

    int sum = 0;
    int len = 0;
    for (int i = 0; i < v.size(); i++)
    {
        sum += v[i];
        if (sum == k)
        {
            len = max(len, i + 1);
        }

        long long rem = sum - k;
        // It finds the remaining sum in map
        if (mp.find(rem) != mp.end())
        {
            int findLen = i - mp[rem];
            len = max(len, findLen);
        }
        // logic for 0 is there in the vector.
        // if zero is there then we don't want to add sum in the map.
        if (mp.find(sum) == mp.end())
        {
            mp[sum] = i;
        }
    }

    cout << len << endl;

    for (auto it : mp)
    {
        cout << it.first << " " << it.second << " " << endl;
    }

    return 0;
}