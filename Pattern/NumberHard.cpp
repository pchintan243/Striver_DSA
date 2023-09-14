#include <iostream>
using namespace std;

void print(int n)
{
    for (int i = -n + 1; i < n; i++)
    {
        for (int j = -n + 1; j < n; j++)
        {
            if (abs(i) > abs(j))
            {
                cout << abs(i) + 1 << " ";
            }
            else
            {
                cout << abs(j) + 1 << " ";
            }
        }
        cout << endl;
    }
}

void print1(int n)
{
    for (int i = 0; i < 2 * n - 1; i++)
    {

        for (int j = 0; j < 2 * n - 1; j++)
        {
            int top = i;
            int left = j;
            int right = (2 * n - 2) - j;
            int down = (2 * n - 2) - i;
            // take minimum distance
            cout << (n - min(min(top, down), min(left, right)));
        }
        cout << endl;
    }
}

int main()
{
    print(3);
    print1(3);
    return 0;
}