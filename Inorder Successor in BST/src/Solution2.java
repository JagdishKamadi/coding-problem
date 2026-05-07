public class Solution2 {
    public int inorderSuccessor(Node root, Node x) {
        if (root == null || x == null) {
            return -1;
        }

        Node current = root;
        Node successor = null;

        while (current != null) {
            if (x.data < current.data) {
                successor = current;
                current = current.left;
            } else if (x.data > current.data) {
                current = current.right;
            } else {
                if (current.right != null) {
                    Node leftMost = current.right;
                    while (leftMost.left != null) {
                        leftMost = leftMost.left;
                    }
                    return leftMost.data;
                }
                return successor != null ? successor.data : -1;
            }
        }

        return -1;
    }
}