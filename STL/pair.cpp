#include <bits/stdc++.h>
using namespace std;

int main()
{
    pair<int, int> p = {1, 3};
    cout << p.first << endl;
    cout << p.second << endl;

    pair<int, pair<int, int>> p2 = {1, {3, 4}};
    cout << p2.first << endl;
    cout << p2.second.first << endl;
    cout << p2.second.second << endl;

    pair<int, int> arr[] = {{7, 8}, {9, 10}};

    cout << arr[1].second << endl;

    return 0;
}