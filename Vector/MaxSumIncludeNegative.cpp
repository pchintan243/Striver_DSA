long long maxSubarraySum(vector<int> arr, int n)
{
    // Write your code here.
    long long sum = 0;
    int maxi = INT_MIN;
    for(int i = 0; i < n; i++) {
        sum += arr[i];
        if(maxi < sum) {
            maxi = sum;
        }
        if(sum < 0) {
            sum = 0;
        }
    }
    return maxi > 0 ? maxi : 0;
}