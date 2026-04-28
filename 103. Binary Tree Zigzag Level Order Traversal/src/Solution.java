import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> shortResult = new ArrayList<>();
        boolean zigzag = false;

        if (root != null) {
            queue.add(root);
            queue.add(null);
        }

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                if (!queue.isEmpty()) {
                    if (zigzag) {
                        Collections.reverse(shortResult);
                    }
                    result.add(shortResult);
                    shortResult = new ArrayList<>();
                    zigzag = !zigzag;
                    queue.add(null);
                } else {
                    break;
                }
            } else {
                shortResult.add(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        if (!shortResult.isEmpty()) {
            if (zigzag) Collections.reverse(shortResult);
            result.add(shortResult);
        }

        return result;
    }
}