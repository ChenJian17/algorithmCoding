package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/5 22:22
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {



        ListNode cur = null;

        while (head != null){
            ListNode tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }

        return cur;


    }

    public static void main(String[] args) {

    }
}
