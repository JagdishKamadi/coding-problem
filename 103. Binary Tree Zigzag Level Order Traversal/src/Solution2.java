import java.util.*;

class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean zigzag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> shortResult = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.poll();
                shortResult.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (zigzag) {
                Collections.reverse(shortResult);
            }
            result.add(shortResult);
            zigzag = !zigzag;
        }
        return result;
    }
}