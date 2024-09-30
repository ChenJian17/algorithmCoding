package top100.linkedList;

import com.chenjian.cn.util.ListNode;
import com.chenjian.cn.util.ListNodeUtil;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/26 22:03
 */
public class SwapNodes {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode res = dumpy;

        ListNode first = head;
        while (first != null && first.next != null){
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            dumpy.next = second;

            dumpy = first;
            first = first.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ListNode head = ListNodeUtil.constructList(nums);
        swapPairs(head);
    }
}
