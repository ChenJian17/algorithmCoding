package dataDance;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/10 22:58
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){

        ListNode t1 = headA, t2 = headB;

        while (t1 != null && t2 != null){
            t2 = t2.next;
            t1 = t1.next;
        }

        ListNode dis = t1 == null ? t2 : t1;
        ListNode lonNode = t1 == null ? headB : headA;
        ListNode shoNode = t1 == null ? headA : headB;

        while (dis != null){
            dis = dis.next;
            lonNode = lonNode.next;
        }

        while (lonNode != shoNode){
            lonNode = lonNode.next;
            shoNode = shoNode.next;
        }
        return shoNode;


    }
}
