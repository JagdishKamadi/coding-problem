import java.util.*;

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        int n = q.size();
        if (k <= 0 || k >= n) {
            return q;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        for (int i = 0; i < n - k; i++) {
            q.offer(q.poll());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        int k = 3;
        System.out.println(new Solution().reverseFirstK(queue, k));
    }
}