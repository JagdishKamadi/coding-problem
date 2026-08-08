import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

// Accepted solution but taking much more time
public class BruteForceSolutionUsingTreeSet {
    public static void main(String[] args) {
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k = 4;
        int[] result = new BruteForceSolutionUsingTreeSet().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int i = 0;
        TreeSet<Integer> set = new TreeSet<>(Comparator
                .comparingInt((Integer idx) -> nums[idx])
                .thenComparingInt(idx -> idx));
        int left = 0;
        for (; i < k; i++) {
            set.add(i);
        }
        result[0] = nums[set.last()];
        int counter = 1;
        for (; i < n; i++) {
            set.remove(left++);
            set.add(i);
            result[counter++] = nums[set.last()];
        }
        return result;
    }
}
