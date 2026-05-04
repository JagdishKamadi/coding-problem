class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeHelper(root, key);
    }

    private TreeNode deleteNodeHelper(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNodeHelper(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNodeHelper(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = minValue(root.right);
            root.right = deleteNodeHelper(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}