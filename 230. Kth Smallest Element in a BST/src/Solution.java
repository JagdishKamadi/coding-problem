class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return result;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallestHelper(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        kthSmallestHelper(root.right, k);
    }
}