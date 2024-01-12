package layOffDays.InplaceReversalLinkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/11/23 20:46
 */
public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        //获取到原链表长度和尾节点
        int n = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            n ++;
        }

        // 新链表尾节点在原链表的位置
        int tail = n - k%n;
        if (tail == n)
            return head;

        last.next = head;
        while (tail-- > 0) {
            last = last.next;
        }
        ListNode res = last.next;
        last.next = null;
        return res;

    }
}
