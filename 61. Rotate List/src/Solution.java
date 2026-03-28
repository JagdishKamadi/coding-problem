class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            n++;
        }
        // make it circular
        current.next = head;
        k = k % n;
        int lengthToBreakNode = n - k;
        ListNode tail = head;
        for (int i = 1; i < lengthToBreakNode; i++) {
            tail = tail.next;
        }
        // make the head
        ListNode newHead = tail.next;
        // attach the last one to null to terminate the loop
        tail.next = null;
        return newHead;
    }
}
