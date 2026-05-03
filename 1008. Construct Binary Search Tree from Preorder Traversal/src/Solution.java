class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                break;
            }
        }
        root.left = buildTree(preorder, start + 1, i - 1);
        root.right = buildTree(preorder, i, end);
        return root;
    }
}