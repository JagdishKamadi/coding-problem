import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = inorder.length - 1;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int inIndex = inorderMap.get(root.val);
        root.right = buildTreeHelper(postorder, inIndex + 1, end);
        root.left = buildTreeHelper(postorder, start, inIndex - 1);
        return root;
    }
}