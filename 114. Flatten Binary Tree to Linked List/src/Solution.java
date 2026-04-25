import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> result = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        preOrder(root);
        TreeNode curr = root;
        // assign first value
        curr.val = result.getFirst();
        for (int i = 1; i < result.size(); i++) {
            curr.left = null;
            curr.right = new TreeNode(result.get(i));
            curr = curr.right;
        }
        // last node cleanup
        curr.left = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = buildTree();
        solution.flatten(treeNode);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        return root;
    }
}