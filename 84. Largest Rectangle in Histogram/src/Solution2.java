import java.util.Map;
import java.util.Stack;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] ps = ps(heights);
        int[] ns = ns(heights);
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (ns[i] - ps[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    private int[] ps(int[] heights) {
        int n = heights.length;
        int[] ps = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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

    private int[] ns(int[] heights) {
        int n = heights.length;
        int[] ns = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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
}
