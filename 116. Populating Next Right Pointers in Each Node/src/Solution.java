import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node prev = null;
        if (root != null) {
            queue.add(root);
            queue.add(null);
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (prev != null) {
                    prev.next = current;
                }
            }
            prev = current;
        }
        return root;
    }
}