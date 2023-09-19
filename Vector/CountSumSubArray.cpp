int findAllSubarraysWithGivenSum(vector<int> &arr, int k)
{
    // Write Your Code Here
    int n = arr.size();
    // Take map for storing the preSum value with count
    map<int, int> mp;
    // Make sure you initialize because it is return the 1 if negative number are there.
    mp[0] = 1;
    // For count the subarray
    int count = 0;
    // For storing the preSum value
    int preSum = 0;
    // If total sum is x --> your target is k --> then obviously you get the x-k in map if it executes.

    for (int i = 0; i < n; i++)
    {
        // Add the elements
        preSum += arr[i];
        // Take the presum value
        int rem = preSum - k;
        // If presum value already exist in the map then it will increase by one
        // If not exist then it will insert the preSum value with one occurence.
        mp[preSum] += 1;
        // It increase the count value if your remaining sum value found in map.
        count += mp[rem];
    }
    return count;
}