vector<vector<int>> triplet(int n, vector<int> &arr)
{
    // Write your code here.

    // vector for store the result
    vector<vector<int>> v;

    // 3 pointer approach and for this approach we have to sort it
    sort(arr.begin(), arr.end());

    for (int i = 0; i < n; i++)
    {
        // If contigues element are same then we have to move it for the next iteration.
        if (i > 0 && arr[i] == arr[i - 1])
            continue;

        // i and k are in constant position and we have to iterate & get the sum using j pointer.
        // 1st pointer i
        // 2nd pointer--> it pointing on element.
        int j = i + 1;
        // 3nd pointer--> pointing to last element.
        int k = n - 1;

        // If j and k cross we have to stop
        while (j < k)
        {
            int sum = arr[i] + arr[j] + arr[k];
            // we have to decrease the sum so we have to decrease the k pointer because it is in ascending order
            if (sum > 0)
            {
                k--;
            }
            // we have to increase the sum so we have to increase the j pointer
            else if (sum < 0)
            {
                j++;
            }
            // sum match which is zero
            else
            {
                // take it and push it
                vector<int> ans = {arr[i], arr[j], arr[k]};
                v.push_back(ans);
                j++;
                k--;
                while (j < k && arr[j] == arr[j - 1])
                    j++;
                while (j < k && arr[k] == arr[k + 1])
                    k--;
            }
        }
    }
    return v;
}
