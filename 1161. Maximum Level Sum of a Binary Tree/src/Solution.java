import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        int maxLevel = new Solution().maxLevelSum(root);
        System.out.println(maxLevel);
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        return root;
    }
}