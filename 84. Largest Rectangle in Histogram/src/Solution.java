import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] ns = ns(heights);
        int[] ps = ps(heights);

        for (int i = 0; i < heights.length; i++) {
            int currentArea = (ns[i] - ps[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    private int[] ps(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ps[i] = -1;
            } else {
                ps[i] = stack.peek();
            }

            stack.push(i);
        }

        return ps;
    }

    private int[] ns(int[] nums) {
        int n = nums.length;
        int[] ns = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ns[i] = n;
            } else {
                ns[i] = stack.peek();
            }

            stack.push(i);
        }

        return ns;
    }

    public static void main(String[] jacks) {
        int[] heights = {2, 4};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}