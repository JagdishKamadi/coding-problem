class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootTree = getTreeInStringFormat(root);
        String subRootTree = getTreeInStringFormat(subRoot);
        return rootTree.contains(subRootTree);
    }

    public String getTreeInStringFormat(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("^");
        sb.append(root.val);
        sb.append(getTreeInStringFormat(root.left));
        sb.append(getTreeInStringFormat(root.right));
        return sb.toString();
    }
}