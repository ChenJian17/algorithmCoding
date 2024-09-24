package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/22 21:39
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }

        return false;
    }
}
