
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {
    public Node flatten(Node head) {
        return helper(head);
    }

    public Node helper(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node next = current.next;
                current.next = helper(current.child);
                current.next.prev = current;
                current.child = null;

                while (current.next != null) {
                    current = current.next;
                }
                if (next != null) {
                    current.next = next;
                    next.prev = current;
                }
            }
            current = current.next;
        }
        return head;
    }
}