package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/24 22:48
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode dump = new ListNode();
        ListNode tail = dump;
        ListNode tmp = dump;
        dump.next = head;
        while (n > 0){
            tail = tail.next;
            --n;
        }

        while (tail.next != null){
            tail = tail.next;
            dump = dump.next;
        }

        ListNode node = dump.next;
        dump.next = node.next;
        node.next = null;

        return dump == tmp ? dump.next : head;

    }
}
