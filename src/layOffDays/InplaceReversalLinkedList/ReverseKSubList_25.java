package layOffDays.InplaceReversalLinkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/30 23:23
 */
public class ReverseKSubList_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;

        // 初始化时指向同一节点
        ListNode pre = dump; //指向待翻转链表的前驱节点
        ListNode end = dump; //指向待翻转链表的末尾节点

        while (end.next != null) {
            //遍历出待翻转链表的末尾节点
            for (int i = 0; i<k && end != null; i++)
                end = end.next;
            if (end == null) break;

            // 保存待翻转的链表的后驱节点
            ListNode next = end.next;
            // 末尾节点指向null，方便截取出待翻转的链表
            end.next = null;

            ListNode start = pre.next;
            pre.next = reverse(start);
            //start从链表头节点翻转成为链表尾节点
            start.next = next;

            pre = start;
            end = pre;
        }
        return dump.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
