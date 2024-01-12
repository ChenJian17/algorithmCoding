package layOffDays.InplaceReversalLinkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/28 21:27
 */
public class ReverseLinkedListII_92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;

        ListNode pre = null;
        ListNode dump = null;
        ListNode last = null;
        ListNode first = head;

        int index = 1;
        while (head != null) {
            if (index < left) {
                pre = head;
                head = head.next;


            }else {
                if(index == left) last = head;
                if (index <= right) {
                    ListNode ned = head.next;
                    head.next = dump;
                    dump = head;
                    head = ned;
                }else
                    break;

            }
            index++;
        }
        if (pre != null) pre.next = dump;
        if (last != null )last.next = head;
        if(left == 1) return dump;
        return first;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode  g = dump;
        ListNode p = dump.next;
        for (int i = 1; i<left; i++) {
            g = g.next;
            p = p.next;
        }

        ListNode cur = p;
        ListNode pre = null;
        for (int i =1; i<=(right-left+1); i++) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        g.next = pre;
        cur.next = p;
        return dump.next;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        ListNode pre = new ListNode(-1);
        ListNode dump = null;
        for (int i = 0; i< arr.length; i++) {

            ListNode node = new ListNode(arr[i]);
            if (i == 0) {
                pre = node;
                dump = node;
            }else {
                pre.next = node;
                pre = node;
            }

        }

        reverseBetween(dump,2,4);
    }
}
