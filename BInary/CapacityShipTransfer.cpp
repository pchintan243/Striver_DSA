int countDays(vector<int> &v, int capacity)
{
    int load = 0;
    int days = 1;
    for (int i = 0; i < v.size(); i++)
    {
        // If capacity is higher then we have to increase the day and current pointer which initialize to load
        if (v[i] + load > capacity)
        {
            days++;
            load = v[i];
        }
        // If capacity is still left then we have to add the load
        else
        {
            load += v[i];
        }
    }
    return days;
}
int leastWeightCapacity(vector<int> &weights, int d)
{
    // Write your code here.

    // Find max element
    int low = *max_element(weights.begin(), weights.end());
    // Find sum of the vector
    int high = accumulate(weights.begin(), weights.end(), 0);

    while (low <= high)
    {
        // At the end of the day low is pointing to minimum days.
        int mid = (low + high) / 2;
        int ans = countDays(weights, mid);
        // If days is satisfied the condition then we have to decrease our high because we have to find minimum days
        if (d >= ans)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return low;
}