import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head.val);
            head = head.next;
        }
        int size = lst.size();
        ListNode newHead = null;
        ListNode current = null;
        if (size >= 1) {
            newHead = new ListNode(lst.getFirst());
            current = newHead;
        }
        for (int i = 2; i < size; i += 2) {
            current.next = new ListNode(lst.get(i));
            current = current.next;
        }
        for (int i = 1; i < size; i += 2) {
            current.next = new ListNode(lst.get(i));
            current = current.next;
        }
        return newHead;
    }
}