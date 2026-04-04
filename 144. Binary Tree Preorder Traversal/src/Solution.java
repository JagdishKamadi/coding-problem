import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<Integer> RESULT = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return RESULT;
    }

    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        RESULT.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}