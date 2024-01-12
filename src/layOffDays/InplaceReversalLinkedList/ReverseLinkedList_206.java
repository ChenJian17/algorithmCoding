package layOffDays.InplaceReversalLinkedList;

import com.chenjian.cn.util.ListNode;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/27 23:05
 */
public class ReverseLinkedList_206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next==null)
            return head;

        ListNode dump = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dump;
            dump = head;
            head = next;
        }
        return dump;

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

        reverseList(dump);
    }
}
