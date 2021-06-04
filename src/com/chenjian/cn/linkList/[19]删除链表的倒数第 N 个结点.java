package com.chenjian.cn.linkList;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1289 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        ListNode iter = head;

        int count = 0;
        while (iter != null){
            count ++;
            iter = iter.next;
        }

        int k = count+1-n;
        ListNode dum = head;
        int num = 1;
        while (dum.next != null){
            if (num+1 == k){
                dum.next = dum.next.next;
                break;
            }else {
                num++;
                dum = dum.next;
            }
        }
        return head;

    }


    public static ListNode removeNthFromEnd2(ListNode head, int n){
        if (head == null || n == 0)
            return head;
        ListNode fast = head;
        while(n-- > 0){
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;

        }
        slow.next = slow.next.next;

        return head;


    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode head = new ListNode(1);
        head.next = node2;
        removeNthFromEnd2(head, 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
