vector<int> findMissingRepeatingNumbers(vector<int> a)
{
    // Write your code here
    long long n = a.size();
    // For storing the array sum
    long long sum1 = 0;
    long long sum2 = 0;
    // It stores the natural number of sum
    long long s1 = (n * (n + 1)) / 2;
    long long s2 = ((n * (n + 1) * (2 * n + 1)) / 6);

    for (int i = 0; i < n; i++)
    {
        sum1 += a[i];
        sum2 += (long long)a[i] * (long long)a[i];
    }

    // val 1 is nothing but (x-y)
    long long val1 = sum1 - s1;
    // val 2 is nothing but (x-Sqaure - y-Sqaure)
    long long val2 = sum2 - s2;

    // (x-Sqaure - y-Sqaure) = (x + y)(x - y);
    // We have x - y so we can find easily x and y
    // x is our repeating value and y is missing value

    val2 /= val1;
    long long x = (val1 + val2) / 2;
    long long y = x - val1;
    return {(int)x, (int)y};
}