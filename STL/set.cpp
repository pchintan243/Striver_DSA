#include <bits/stdc++.h>
using namespace std;

int main()
{
    set<int> s;
    s.insert(2);
    s.emplace(4);
    s.insert(6);
    s.insert(8);

    // set stores unique value and stores in sorted array

    // It retuns value if value exist and if value not exist then it retuns last index of set
    auto it = s.find(1);

    s.erase(4);
    cout << *it;

    // It retuns 1 if value exist otherwise 0
    s.count(1);

    // lower bound retuns the index if exist other wise next index
    auto i = s.lower_bound(2);
    // upper bound retuns the immediate after index in both cases
    auto i = s.upper_bound(4);

    return 0;
}