package leetcode.easy.linkedlist.reverse_ll;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // iterative : O(n) time, O(1) space
    static ListNode reverseList(ListNode head) {
        ListNode before = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode after = cur.next; // lưu node tiếp theo
            cur.next = before;         // đảo chiều con trỏ
            before = cur;              // tiến prev lên
            cur = after;               // tiến current lên
        }

        return before; // new head
    }
}
