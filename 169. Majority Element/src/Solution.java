class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int majorElement = nums[0];
        int count = 0;

        for (int i : nums) {
            if (count == 0) {
                majorElement = i;
            }
            if (majorElement == i) {
                count++;
            } else {
                count--;
            }

        }
        return majorElement;
    }
}