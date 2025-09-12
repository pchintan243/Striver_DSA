package Medium;

public class NextPermutation {
// Steps
// 1. Find Decreasing number from the right of the list
// 2. Find immediate greater number than decreasing number on right of the list
// 3. Swap that both number
// 4. Reverse that sub list
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n - 1;
        int j = k - 1;

        while(j >= 0 && k >= 0) {
            if(nums[j] < nums[k]) {
                int ind = k;
                int num = nums[k];
                for(int l = k + 1; l < n; l++) {
                    if(nums[j] < nums[l]) {
                        if(num >= nums[l]) {
                            ind = l;
                            num = nums[l];
                        }
                    }
                }
                swap(ind, j, nums);
                reverse(nums, k, n - 1);
                return;
            }
            j--;
            k--;
        }

        reverse(nums, 0, n - 1);
    }
    private void reverse(int[] nums, int k, int j) {
        while (k < j) {
            swap(k, j, nums);
            k++;
            j--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}