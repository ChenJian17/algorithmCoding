package dataDance;

import com.chenjian.cn.util.ListNode;

import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/10 22:44
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode dump = null;
        ListNode pre = null;

        while (head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
