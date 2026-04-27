import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(new Pair(root, 0));
        }
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            int startIndex = queue.peek().index;
            int endIndex = queue.getLast().index;
            maxWidth = Math.max(maxWidth, endIndex - startIndex + 1);
            for (int i = 0; i < currentSize; i++) {
                Pair current = queue.poll();
                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, current.index * 2 + 1));
                }
                if (current.node.right != null) {
                    queue.offer(new Pair(current.node.right, current.index * 2 + 2));
                }
            }
        }
        return maxWidth;
    }

    private record Pair(TreeNode node, int index) {

    }
}