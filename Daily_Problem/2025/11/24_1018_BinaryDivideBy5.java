package Daily_Problem.2025.11;
import java.util.ArrayList;
import java.util.List;

class 24_1018_BinaryDivideBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;

    }
}