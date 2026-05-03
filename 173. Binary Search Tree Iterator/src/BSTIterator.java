import java.util.Stack;

public class BSTIterator {
    private static final Stack<Integer> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
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
        // as we are using the stack, so we need to store the element in reverse order
        inorderTraversal(root.right);
        stack.push(root.val);
        inorderTraversal(root.left);
    }
}
