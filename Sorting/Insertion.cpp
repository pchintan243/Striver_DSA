#include <bits/stdc++.h>
using namespace std;

void insertion(int *arr, int n)
{
    for (int i = 1; i < n; i++)
    {
        int j = i;
        while (j > 0 && (arr[j - 1] > arr[j]))
        {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
}
int main()
{
    int arr[] = {1, 3, 2, 4, 5, 2};
    int n = 6;
    insertion(arr, n);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}