#include <bits/stdc++.h>
using namespace std;

int main()
{
    list<int> ls;
    ls.push_back(2);
    ls.emplace_back(2);

    // It has additionaly method which is push_front
    // It has additionaly method which is emplace_front

    // List is also work like linked list
    // It takes less time to vector
    ls.push_front(5);

    for (auto it : ls)
    {
        cout << it << endl;
    }

    return 0;
}