#include <bits/stdc++.h>
using namespace std;

int main()
{

    vector<int> v;
    int d = 3;
    for (int i = 0; i < 6; i++)
    {
        v.push_back(i + 1);
    }
    d = d % v.size();

    reverse(v.begin(), v.begin()+d);
    reverse(v.begin()+d, v.end());
    reverse(v.begin(), v.end());
    for (int i = 0; i < 6; i++)
    {
        cout << v[i] << " ";
    }
    return 0;
}