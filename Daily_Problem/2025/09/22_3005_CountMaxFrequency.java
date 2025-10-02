package Daily_Problem.2025.09;
import java.util.HashMap;
import java.util.Map;

public class 22_3005_CountMaxFrequency {
    public int maxFrequencyElements(int[] nums) {
        // Find the frequency of each element
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        // Determine the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencies.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Calculate the total frequencies of elements with the maximum frequency
        int frequencyOfMaxFrequency = 0;
        for (int frequency : frequencies.values()) {
            if (frequency == maxFrequency) {
                frequencyOfMaxFrequency++;
            }
        }
        return frequencyOfMaxFrequency * maxFrequency;
    }
}