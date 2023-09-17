// 485. Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int count = 0, maxCount = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 1) {
                count++;
                maxCount = max(count, maxCount);
            }
            else {
                count = 0;
            }
        }
        return maxCount;
    }
};