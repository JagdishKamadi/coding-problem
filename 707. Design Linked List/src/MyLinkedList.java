
class MyLinkedList {

    private Node head;

    public MyLinkedList() {
        head = new Node(-1); // Dummy head
    }

    public int get(int index) {
        if (index < 0 || index >= getLen()) {
            return -1;
        }

        Node temp = head.next;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void addAtTail(int val) {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        int len = getLen();

        if (index < 0 || index > len) {
            return;
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtIndex(int index) {
        int len = getLen();

        if (index < 0 || index >= len) {
            return;
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    private int getLen() {
        int count = 0;
        Node temp = head.next;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    private class Node {
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
}