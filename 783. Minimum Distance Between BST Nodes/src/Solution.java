import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, (result.get(i) - result.get(i - 1)));
        }
        return min;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}