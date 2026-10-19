class Solution {
    /*
    input  = nums = [5,-3,5]
    output = 10
     */
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = 0;
        int maxSum = nums[0];
        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all numbers are negative, maxSum holds the correct (non-empty) answer;
        // totalSum - minSum would incorrectly represent an empty subarray.
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}