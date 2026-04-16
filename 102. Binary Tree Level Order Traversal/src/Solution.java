import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(root, result);
        return result;
    }

    private void getResult(TreeNode root, List<List<Integer>> result) {
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    result.add(temp);
                    temp = new ArrayList<>();
                    queue.add(null);
                    continue;
                } else {
                    break;
                }
            }
            temp.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        if (!temp.isEmpty()) {
            result.add(temp);
        }
    }
}