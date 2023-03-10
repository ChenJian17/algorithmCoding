package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 递归 链表 
// 👍 555 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode dump = null;
        ListNode cur = head;
        while (cur != null) {
            head = cur.next;
            cur.next = dump;
            dump = cur;
            cur = head;
        }
        return dump;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
