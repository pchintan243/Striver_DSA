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

int main()
{
    print(3);
    return 0;
}