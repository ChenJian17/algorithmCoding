package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/30 22:02
 */
public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode();
        dump.next = head;

        ListNode pre = dump; //指向待翻转链表的前驱节点
        ListNode end = dump; //指向待翻转链表的末尾节点
        while (end.next != null){
            for (int i = 0; i<k && end != null; i++){
                end = end.next;
            }
            if (end == null) break;

            ListNode next = end.next;
            end.next = null;

            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;

            pre = next;
            end = pre;
        }

        return dump.next;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head, pre = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
