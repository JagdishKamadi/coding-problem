class Solution2 {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int min, int max) {
        if (index >= preorder.length) {
            return null;
        }
        int val = preorder[index];
        if (val < min || val > max) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        index++;

        root.left = buildTree(preorder, min, val);
        root.right = buildTree(preorder, val, max);

        return root;
    }
}