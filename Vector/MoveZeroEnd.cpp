vector<int> moveZeros(int n, vector<int> a)
{
    int j = 0, i = 0;
    while (i != n)
    {
        if (a[i] == 0)
        {
            i++;
        }
        else {
            if(i != j) 
                swap(a[i],a[j]);
            i++;j++;
        }
    }
    return a;
}
