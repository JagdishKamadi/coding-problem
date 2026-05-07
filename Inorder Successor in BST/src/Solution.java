import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> result = new ArrayList<>();

    public int inorderSuccessor(Node root, Node x) {
        inorder(root);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == x.data && (i + 1) < result.size()) {
                return result.get(i + 1);
            }
        }
        return -1;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        result.add(root.data);
        inorder(root.right);
    }
}