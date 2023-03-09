package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 递归 链表 双指针 
// 👍 389 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
           res[i++] = stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
