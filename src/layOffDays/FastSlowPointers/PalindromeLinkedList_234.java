package layOffDays.FastSlowPointers;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/17 22:53
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head, slow = head;
        ListNode pre = head, prepare = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepare;
            prepare = pre;
        }

        //说明链表长度为奇数
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;


    }
}
