vector<int> findMissingRepeatingNumbers(vector<int> a)
{
    // Write your code here
    int n = a.size();
    // For storing the array sum
    int sum1 = 0;
    int sum2 = 0;
    // It stores the natural number of sum
    int s1 = (n * (n + 1)) / 2;
    int s2 = ((n * (n + 1) * (2 * n + 1)) / 6);

    for (int i = 0; i < n; i++)
    {
        sum1 += a[i];
        sum2 += a[i] * a[i];
    }

    // val 1 is nothing but (x-y)
    int val1 = sum1 - s1;
    // val 2 is nothing but (x-Sqaure - y-Sqaure)
    int val2 = sum2 - s2;

    // (x-Sqaure - y-Sqaure) = (x + y)(x - y);
    // We have x - y so we can find easily x and y
    // x is our repeating value and y is missing value

    val2 /= val1;
    int x = (val1 + val2) / 2;
    int y = x - val1;
    return {x, y};
}