class Solution {
    public Node flattenBST(Node root) {
        return flattenBSTHelper(root);
    }

    private Node flattenBSTHelper(Node root) {
        if (root == null) {
            return null;
        }
        Node head = flattenBSTHelper(root.left);
        root.left = null;
        root.right = flattenBSTHelper(root.right);
        if (head != null) {
            Node temp = head;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root;
        } else {
            head = root;
        }
        return head;
    }
}
