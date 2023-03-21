package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 链表 双指针 
// 👍 444 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution23 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode res = null;
        while (k > 0) {
            res = stack.pop();
            k --;
        }
        return res;

    }

    //two pointers
}
//leetcode submit region end(Prohibit modification and deletion)
