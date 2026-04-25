import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, map, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preOrder, Map<Integer, Integer> map, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = map.get(preOrder[rootIndex]);
        if (left < mid) {
            root.left = buildTreeHelper(preOrder, map, rootIndex + 1, left, mid - 1);
        }
        if (mid < right) {
            root.right = buildTreeHelper(preOrder, map, rootIndex + mid - left + 1, mid + 1, right);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        printPreOrder(root);
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}