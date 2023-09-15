#include <bits/stdc++.h>
#include <map>
using namespace std;

int main()
{
    map<int, int> m;
    // map stores data in key's sorted order.

    m.insert({2, 3});
    m.insert(pair<int, int>(5, 50));
    m.insert(pair<int, int>(4, 20));

    m[2] = 10;
    // key should be unique.

    for (auto it : m)
    {
        cout << it.first << endl;
        cout << it.second << endl;
    }
    // multiset has stores duplicate keys
    return 0;
}