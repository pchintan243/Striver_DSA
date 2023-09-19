#include <bits/stdc++.h>
using namespace std;

int main()
{

    int n = 13, r = 3;
    long long ans = 1;
    for (int i = 0; i < r; i++)
    {
        ans *= (n - i);
        ans /= (i + 1);
    }
    cout << ans;
    return 0;
}