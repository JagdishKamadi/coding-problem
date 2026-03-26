public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }

    private static ListNode buildListNode(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        int i = 0;
        while ((++i) < n) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("[]");
        }
        System.out.print("[");
        while (head.next != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.print(head.val + "]");
    }

    public static void main(String[] args) {

    }
}