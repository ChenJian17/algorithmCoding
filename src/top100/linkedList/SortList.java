package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/3 17:00
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null){
            if (left.val < right.val){
                res.next = left;
                left = left.next;
                res = res.next;
            }else {
                res.next = right;
                right = right.next;
                res = res.next;
            }
        }

        res.next = left == null ? right : left;
        return h.next;

    }
}
