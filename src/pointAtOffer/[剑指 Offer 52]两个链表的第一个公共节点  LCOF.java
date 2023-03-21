package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 哈希表 链表 双指针 
// 👍 615 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != null && l2 != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            l1 = l1.next;
            headA = headA.next;
        }
        while (l2 != null){
            l2 = l2.next;
            headB = headB.next;
        }

        while (headB != headA){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
