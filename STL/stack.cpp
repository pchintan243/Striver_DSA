#include <bits/stdc++.h>
#include <stack>
using namespace std;

int main()
{
    stack<int> s;
    s.push(1);
    s.push(3);
    s.push(4);
    s.emplace(9);

    s.pop();
    cout << s.top() << endl;
    cout << s.size() << endl;
    return 0;
}