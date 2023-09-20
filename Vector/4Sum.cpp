vector<vector<int>> fourSum(vector<int> &nums, int target)
{
    // Write your code here
    int n = nums.size();

    // 4 pointer approach and for this approach we have to sort it
    sort(nums.begin(), nums.end());
    vector<vector<int>> ans;
    for (int i = 0; i < n - 3; i++)
    {
        // if I is matching it's previous one then we have to move it because for this element all possibility are already checked.
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        for (int j = i + 1; j < n - 2; j++)
        {
            // If j is matching it's previous one then we have to move because for this element all possibility are already checked.
            if (j != i + 1 && nums[j] == nums[j - 1])
                continue;

            // k is pointing last element
            int k = n - 1;
            // l is pointing immediate after j-th pointing
            int l = j + 1;

            // if l and k is not cross then still we have to check
            while (l < k)
            {
                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                // If sum is higher than target then we have to decrease the k pointer because it is in ascending order
                if (sum > target)
                {
                    k--;
                }
                // If sum is lesser than target then we have to increase the sum so we have to increase the l pointer
                else if (sum < target)
                {
                    l++;
                }
                else
                {
                    vector<int> v = {nums[i], nums[j], nums[l], nums[k]};
                    ans.push_back(v);
                    k--;
                    l++;
                    while (l < k && nums[k] == nums[k + 1])
                    {
                        k--;
                    }
                    while (l < k && nums[l] == nums[l - 1])
                    {
                        l++;
                    }
                }
            }
        }
    }

    return ans;
}