#include <iostream>
using namespace std;

void pattern(int n)
{
    for (int i = 0; i < n; i++)
    {
        int star = i;
        if (i % 2 == 0)
            star = 1;
        else
            star = 0;
        for (int j = 0; j <= i; j++)
        {
            cout << star;
            star = 1 - star;
        }
        cout << endl;
    }
}

int main()
{
    pattern(5);
    return 0;
}