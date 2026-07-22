import java.util.Arrays;

class Solution2 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        Arrays.sort(nums);
        int num = nums[0];
        for (int i = 1; i < n; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count = 1;
                num = nums[i];
            }

            if (count > n / 2) {
                return num;
            }
        }
        return num;
    }
}