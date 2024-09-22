package top100.linkedList;

import com.chenjian.cn.util.ListNode;
import com.chenjian.cn.util.ListNodeUtil;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/9 21:45
 */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        ListNode node = ListNodeUtil.constructList(nums);
        System.out.println(isPalindrome(node));
    }
}
