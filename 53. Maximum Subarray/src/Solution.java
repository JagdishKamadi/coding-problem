class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            max = Math.max(max, currentSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums)); // Output: 6
    }
}