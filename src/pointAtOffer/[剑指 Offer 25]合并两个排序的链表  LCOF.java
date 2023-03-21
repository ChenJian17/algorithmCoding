package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 递归 链表 
// 👍 330 👎 0


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
class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
//        while (l1 != null){
//            cur.next = l1;
//            l1 = l1.next;
//            cur = cur.next;
//        }
//        while (l2 != null){
//            cur.next = l2;
//            l2 = l2.next;
//            cur = cur.next;
//        }
        cur.next = l1 != null ? l1 : l2;
        return dump.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
