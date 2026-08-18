class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Duplicate found
            if (current.next != null &&
                    current.val == current.next.val) {

                int duplicateValue = current.val;

                // Skip all nodes having duplicate value
                while (current != null &&
                        current.val == duplicateValue) {
                    current = current.next;
                }

                prev.next = current;

            } else {

                // Current value is unique so far
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}