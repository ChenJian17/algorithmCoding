package layOffDays.FastSlowPointers;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/15 23:27
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
