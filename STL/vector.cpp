#include <bits/stdc++.h>
#include <vector>
using namespace std;

int main()
{
    vector<pair<int, int>> vec;

    vector<int> v;
    v.push_back(2);
    v.emplace_back(9);

    v.erase(v.begin()); //  removes 2

    for (auto it = v.begin(); it != v.end(); it++)
    {
        cout << *it << endl;
    }

    vector<int> v2(5, 100);
    v2.erase(v2.begin() + 2, v2.begin() + 4);

    v2.insert(v2.begin(), 200);
    v2.insert(v2.begin() + 2, 3, 300);

    v2.pop_back();
    for (auto it : v2)
    {
        cout << it << endl;
    }

    return 0;
}