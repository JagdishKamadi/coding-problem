import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            if (remainder < 0) {
                int elementToStore = remainder + k;
                Integer value = freq.get(elementToStore);
                if (value != null) {
                    count += value;
                    freq.put(elementToStore, value + 1);
                } else {
                    freq.put(elementToStore, 1);
                }
            } else if (!freq.containsKey(remainder)) {
                freq.put(remainder, 1);
            } else {
                Integer value = freq.get(remainder);
                count += value;
                freq.put(remainder, value + 1);
            }
        }
        return count;
    }
}