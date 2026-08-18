import java.util.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        Map<Integer, Integer> map = new TreeMap<>();

        // Count frequency
        while (head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }

        // Create result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                current.next = new ListNode(entry.getKey());
                current = current.next;
            }
        }

        return dummy.next;
    }
}