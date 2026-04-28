import java.util.HashMap;
import java.util.Map;

class Solution2 {

    private int preIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        int inIdx = inorderMap.get(root.val);

        root.left = buildTreeHelper(preorder, start, inIdx - 1);
        root.right = buildTreeHelper(preorder, inIdx + 1, end);

        return root;
    }
}