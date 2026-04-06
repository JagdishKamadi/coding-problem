class Solution1 {
    private int counter = 0;

    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, 0, 0, target);
        return counter;
    }

    private void helper(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            if (currentSum == target) {
                counter++;
            }
            return;
        }
        // go for addition
        helper(nums, index + 1, currentSum + nums[index], target);
        // go for substraction
        helper(nums, index + 1, currentSum - nums[index], target);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new Solution1().findTargetSumWays(nums, target));
    }
}