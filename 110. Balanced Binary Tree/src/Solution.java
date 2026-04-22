class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root);
    }

    private boolean isBalancedHelper(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalancedHelper(root.left) == false || isBalancedHelper(root.right) == false) {
            return false;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}