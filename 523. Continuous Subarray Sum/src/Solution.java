import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = (int) (prefixSum % k);
            Integer value = map.get(remainder);
            if (value != null && i - value >= 2) {
                return true;
            }
            map.putIfAbsent(remainder, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 13;
        System.out.println(new Solution().checkSubarraySum(nums, k));
    }
}