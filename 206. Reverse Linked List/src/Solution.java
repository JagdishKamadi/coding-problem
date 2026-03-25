import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode reverseList(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head.val);
            head = head.next;
        }
        lst = lst.reversed();
        if(lst.isEmpty()){
            return null;
        }
        ListNode first = new ListNode(lst.getFirst());
        ListNode travel = first;
        for (int i = 1; i < lst.size(); i++) {
            travel.next = new ListNode(lst.get(i));
            travel = travel.next;
        }
        return first;
    }
}