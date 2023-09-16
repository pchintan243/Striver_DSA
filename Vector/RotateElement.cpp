#include <bits/stdc++.h>
using namespace std;

int main()
{

    vector<int> v;
    int d = 2;
    for (int i = 0; i < 6; i++)
    {
        v.push_back(i + 1);
    }
    d = d % v.size();
    // for left rotation
    reverse(v.begin(), v.begin() + d);
    reverse(v.begin() + d, v.end());
    reverse(v.begin(), v.end());
    cout << "Left rotation:" << endl;
    for (int i = 0; i < 6; i++)
    {
        cout << v[i] << " ";
    }

    cout << endl;

    vector<int> v1;
    int d1 = 2;
    for (int i = 0; i < 6; i++)
    {
        v1.push_back(i + 1);
    }
    d1 = d1 % v1.size();

    // for right rotation
    reverse(v1.end() - d1, v1.end());
    reverse(v1.begin(), v1.end() - d1);
    reverse(v1.begin(), v1.end());

    cout << "Right rotation:" << endl;
    for (int i = 0; i < 6; i++)
    {
        cout << v1[i] << " ";
    }
    return 0;
}