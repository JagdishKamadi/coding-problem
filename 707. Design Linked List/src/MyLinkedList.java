class MyLinkedList {
    Node head;

    public MyLinkedList() {
        head = new Node(-1);
    }

    public int get(int index) {
        int len = getLen();
        if (index < 0 || index >= len) {
            return -1;
        }
        Node temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node firstNode = new Node(val);
        firstNode.next = head.next;
        head.next = firstNode;
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
        Node temp = head.next;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    private class Node {
        private Node next;
        private Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }
}