class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int maxOnes = 0;
        int zerosCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zerosCount++;
            }
            while (zerosCount > k) {
                if (nums[start] == 0) {
                    zerosCount--;
                }
                start++;
            }
            maxOnes = Math.max(maxOnes, i - start + 1);
        }
        return maxOnes;
    }
}