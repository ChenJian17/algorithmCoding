package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/24 21:25
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }

        ListNode tmp = head;
        while (tmp != slow) {
            tmp = tmp.next;
            slow = slow.next;
        }

        return slow;

    }
}
