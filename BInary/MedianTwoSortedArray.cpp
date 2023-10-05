// Linear approach

double median(vector<int> &a, vector<int> &b)
{
    // Write your code here.
    int n1 = a.size();
    int n2 = b.size();
    // Take size addition
    int n = n1 + n2;
    // Take two pointer to iterating over the array
    int i = 0, j = 0;
    // At the end of the day ind2 & ind1 points middle element
    int ind2 = n / 2;
    int ind1 = ind2 - 1;
    // Count is use to find middle element if is equal to n/2 then we store it into in1el and ind2el based on some conditions
    int cnt = 0;
    int ind1el = -1;
    int ind2el = -1;

    while (i < n1 && j < n2)
    {
        if (a[i] < b[j])
        {
            if (cnt == ind1)
                ind1el = a[i];
            if (cnt == ind2)
                ind2el = a[i];
            cnt++;
            i++;
        }
        else
        {
            if (cnt == ind1)
                ind1el = b[j];
            if (cnt == ind2)
                ind2el = b[j];
            cnt++;
            j++;
        }
    }
    while (i < n1)
    {
        if (cnt == ind1)
            ind1el = a[i];
        if (cnt == ind2)
            ind2el = a[i];
        cnt++;
        i++;
    }
    while (j < n2)
    {
        if (cnt == ind1)
            ind1el = b[j];
        if (cnt == ind2)
            ind2el = b[j];
        cnt++;
        j++;
    }

    // If merged sorted array size is odd number then return ind2el Otherwise take sum of that divide by 2
    if (n % 2 == 1)
    {
        return ind2el;
    }
    return (double)((double)(ind1el + ind2el)) / 2.0;
}