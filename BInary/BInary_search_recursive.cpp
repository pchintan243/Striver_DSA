int rec(vector<int> &nums, int low, int high, int target)
{
    int mid = (low + high) / 2;
    if (low > high)
        return -1;
    else if (nums[mid] == target)
        return mid;
    else if (nums[mid] < target)
        return rec(nums, mid + 1, high, target);
    else
        return rec(nums, low, mid - 1, target);
}
int search(vector<int> &nums, int target)
{
    // Write your code here.
    return rec(nums, 0, nums.size() - 1, target);
}