class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthHelper(root.left), maxDepthHelper(root.right));
    }
}