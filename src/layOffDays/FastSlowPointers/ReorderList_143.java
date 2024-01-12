package layOffDays.FastSlowPointers;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/20 22:37
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow, dump = null;

        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = dump;
            dump = pre;
            pre = tmp;
        }


        ListNode order = head;
        ListNode jump = head;

        while (jump != slow && dump != null) {
            jump = jump.next;
            order.next = dump;
            dump = dump.next;
            order = order.next;
        }
        if (jump != slow)
            order.next = head;
        if (dump != null)
            order.next = dump;


    }


    public void reorderList1(ListNode head) {
        if (head == null)
            return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1,l2);

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp, l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
