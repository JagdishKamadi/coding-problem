import java.util.Arrays;

// works fine but consuming more time
public class BruteForceSolution {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new BruteForceSolution().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int i = 0;
        int max = nums[0];
        int counter = 1;
        for (; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        result[0] = max;
        for (; i < n; i++) {
            max = nums[i];
            for (int left = i - k + 1; left < i; left++) {
                max = Math.max(max, nums[left]);
            }
            result[counter++] = max;
        }
        return result;
    }
}
