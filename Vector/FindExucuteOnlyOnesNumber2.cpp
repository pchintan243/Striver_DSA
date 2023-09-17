// 136. Single Number
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        int xorVal = 0;
	    for(int i = 0; i < n; i++) {
		    xorVal ^= nums[i];
	    }
	    return xorVal;
    }
};