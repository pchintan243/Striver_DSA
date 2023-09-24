// it's same as largestSubArraySumMini file.

int paintPartition(vector<int> &boards, int mid)
{
    int count = 1;
    int last = 0;
    for (int i = 0; i < boards.size(); i++)
    {
        if (last + boards[i] <= mid)
        {
            last += boards[i];
        }
        else
        {
            last = boards[i];
            count++;
        }
    }
    return count;
}
int findLargestMinDistance(vector<int> &boards, int k)
{
    //    Write your code here.
    int low = *max_element(boards.begin(), boards.end());
    int high = accumulate(boards.begin(), boards.end(), 0);

    while (low <= high)
    {
        int mid = (low + high) / 2;

        int ans = paintPartition(boards, mid);

        if (ans <= k)
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