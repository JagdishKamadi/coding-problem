import java.util.Stack;

public class BSTIterator2 {
    private Stack<Integer> stack = new Stack<>();

    public BSTIterator2(TreeNode root) {
        inorderTraversal(root);
    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // Reverse inorder: Right → Root → Left
        inorderTraversal(root.right);
        stack.push(root.val);
        inorderTraversal(root.left);
    }
}