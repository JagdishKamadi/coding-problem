import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    /**
     * Returns max value for each window of size k using a monotonic deque of indices.
     * Example: nums = [1,3,-1,-3,5,3,6,7], k = 3 -> [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || k == 1) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        // Build first window: keep indices in decreasing value order.
        for (; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        // Front index always holds max for current window.
        result[0] = nums[deque.peekFirst()];
        int counter = 1;
        for (; i < n; i++) {
            // Remove index that moved out of this window.
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Drop smaller values from back; they can never be future maxima.
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // Record max for window ending at i.
            result[counter++] = nums[deque.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k = 4;
        int[] result = new Solution().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}