package top100.linkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/5 18:02
 */
public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode l1 = headA, l2 = headB;

        while (l1 != null && l2 != null){
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode longNode = l1 == null ? headB : headA;

        ListNode shortNode = l1 == null ? headA : headB;

        ListNode tmp = l1 == null ? l2 : l1;

        while (tmp != null){
            tmp = tmp.next;
            longNode = longNode.next;
        }

        while (shortNode != longNode){
            shortNode = shortNode.next;
            longNode = longNode.next;
        }

        return shortNode;



    }
}
