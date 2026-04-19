class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}