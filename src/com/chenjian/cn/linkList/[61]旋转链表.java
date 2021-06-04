package com.chenjian.cn.linkList;//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 505 👎 0


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
class Solution6166 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k==0)
            return null;
        if (head.next == null)
            return head;
        int n = 1;

        ListNode dump = head;
        while (dump.next != null){
            n++;
            dump = dump.next;
        }
        dump.next = head;
        int count = 0;
        ListNode temp = head;
        int node = n-1 -(k%n);
        ListNode res = null;
        while (temp.next != null){

            if (count == node){
                res = temp.next;
                temp.next = null;
                break;
            }else {
                temp = temp.next;
                count ++;
            }

        }
        return res;


    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k== 0 || head.next == null)
            return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null){
            n++;
            iter = iter.next;
        }
        iter.next = head;
        int add = n - k%n;
        while(add -- >0){
            iter = iter.next;
        }
        ListNode res = iter.next;
        iter.next = null;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
