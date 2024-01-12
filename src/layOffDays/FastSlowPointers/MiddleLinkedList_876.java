package layOffDays.FastSlowPointers;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/17 22:29
 */
public class MiddleLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return slow;
            fast = fast.next.next;
            slow = slow.next;
        }


    }
}
