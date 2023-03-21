package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 链表 
// 👍 296 👎 0


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
class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val){
                pre = cur;
                cur = cur.next;
            }else {
                pre.next = cur.next;
                cur.next = null;
                break;
            }
        }
        return dump.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
