#include <bits/stdc++.h>
using namespace std;

int main()
{
    // multiset same as set only it allows to contain duplicate values.

    multiset<int> s;
    s.insert(2);
    s.emplace(4);
    s.insert(6);
    s.insert(8);

    // it counts all 2
    s.count(2);

    // it erase all 2
    s.erase(2);

    return 0;
}