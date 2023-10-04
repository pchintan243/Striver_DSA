int numberOfGasStationRequired(vector<int> &arr, long double dist)
{
    // Count number of gas station
    int cnt = 0;
    for (int i = 1; i < arr.size(); i++)
    {
        int numberInBetween = ((arr[i] - arr[i - 1]) / dist);
        if ((arr[i] - arr[i - 1]) / dist == numberInBetween * dist)
        {
            numberInBetween--;
        }
        cnt += numberInBetween;
    }
    return cnt;
}

double minimiseMaxDistance(vector<int> &arr, int k)
{
    // Write your code here.
    int n = arr.size();

    // Make sure you take long double because in some cases we put gas station into floating point number as well
    long double low = 0;
    long double high = 0;

    // Find the highest distance among all the numbers
    for (int i = 0; i < n - 1; i++)
    {
        high = max(high, (long double)(arr[i + 1] - arr[i]));
    }

    // Take difference as 10 power -6 which is given in problem
    long double diff = 1e-6;

    // Differnce of high - low is greater than diff otherwise limit will exist
    while (high - low > diff)
    {

        long double mid = (low + high) / (2.0);
        // Count the number of gas station that we are able to put in to the array
        int cnt = numberOfGasStationRequired(arr, mid);

        // We are not moving like one behalf of the point array otherwise it removes current pointer
        if (cnt > k)
        {
            low = mid;
        }
        else
        {
            high = mid;
        }
    }
    // At the end of the day your high is pointing to the answer
    return high;
}
