package layOffDays.FastSlowPointers;

import com.chenjian.cn.util.ListNode;

import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/16 16:15
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
