class CntAllSubSequence {
    List<Integer> temp = new ArrayList<Integer>();
    public int generateComb(int[] nums, int ind, int sum, int target) {
        if(nums.length == ind) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        temp.add(nums[ind]);
        int cnt1 = generateComb(nums, ind + 1, sum + nums[ind], target);   
        temp.remove(temp.size() - 1);
        int cnt2 = generateComb(nums, ind + 1, sum, target);
        
        return cnt1 + cnt2;
    }
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        return generateComb(nums, 0, 0, target);
    }
}