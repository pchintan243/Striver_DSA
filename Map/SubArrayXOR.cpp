int subarraysWithSumK(vector<int> a, int b)
{
    // target is b that we have to find
    int n = a.size();
    map<int, int> mp;
    // we initially take it 0 xor with 1 occurence
    mp[0] = 1;
    // Store the XOR value
    int xorOperation = 0;
    // Store the how many subarrays exist that we have to find
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        // XOR with all element one by one
        xorOperation ^= a[i];
        mp[xorOperation]++;
        int remaining = xorOperation ^ b;
        count += mp[remaining];
    }
    return count;
}