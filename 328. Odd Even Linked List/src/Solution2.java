class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;   // link next odd
            odd = odd.next;

            even.next = odd.next;   // link next even
            even = even.next;
        }

        odd.next = evenHead; // attach even list after odd

        return head;
    }
}