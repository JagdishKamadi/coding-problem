class Solution2 {
    public TreeNode nextNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = nextNode;
        nextNode = root;
    }
}