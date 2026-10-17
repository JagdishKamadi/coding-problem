class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minCount = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minCount = Math.min(minCount, right - left + 1);
                currentSum -= nums[left++];
            }
        }

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}