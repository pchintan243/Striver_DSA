import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int n = nums.length;
        int minReq = (int) ((n / 3) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1++;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2++;
                el2 = nums[i];
            } else if (el1 == nums[i]) {
                cnt1++;
            } else if (el2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (el1 == nums[i]) {
                cnt1++;
            }
            if (el2 == nums[i]) {
                cnt2++;
            }
        }

        if (minReq <= cnt1)
            ans.add(el1);
        if (minReq <= cnt2)
            ans.add(el2);

        return ans;
    }
}
