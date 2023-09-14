#include <bits/stdc++.h>
#include <queue>
using namespace std;

int main()
{
    // it stores element in ascending order
    priority_queue<int> p;

    p.push(5);
    p.emplace(8);
    p.push(2);

    cout << p.top() << endl;
    return 0;
}