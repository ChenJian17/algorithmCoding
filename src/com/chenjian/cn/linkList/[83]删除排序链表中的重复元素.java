package com.chenjian.cn.linkList;//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 536 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import com.chenjian.cn.util.ListNode;

import java.util.HashSet;
import java.util.Set;

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
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
       if (head == null || head.next == null)
           return null;
       Set<Integer> list = new HashSet<>();
       ListNode dump = new ListNode(-1);
       dump.next = head;
       ListNode pre = dump;
       ListNode cur = head;
       while (cur != null){
           if (list.contains(cur.val)) {
               pre.next = cur.next;
               cur = cur.next;
           }else {
               list.add(cur.val);
               pre = pre.next;
               cur = cur.next;

           }

       }
       return dump.next;

    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
