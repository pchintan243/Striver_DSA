class 13_3335_TotalCharAddT_Times {
    public int lengthAfterTransformations(String s, int t) {
        int mod = (int) 1e9 + 7;
        int[] nums = new int[26];

        for(char ch: s.toCharArray()) {
            nums[ch - 'a']++;
        }

        while(t-- > 0) {
            int[] curr = new int[26];

            for(int j = 0; j < 26; j++) {
                if(j == 25 && nums[j] > 0) {
                    curr[0] = (curr[0] + nums[25]) % mod;
                    curr[1] = (curr[1] + nums[25]) % mod;
                } else {
                    if(j < 25)
                        curr[j + 1] = (curr[j + 1] + nums[j]) % mod;
                }
            }
            nums = curr;
        }

        int ans = 0;
        for(int num : nums) {
            ans = (ans + num) % mod;
        }
        return ans;
    }
}