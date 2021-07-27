package com.chenjian.cn.util;

import java.util.List;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: com.chenjian.cn.util
 * @Author: Joker
 * @CreateTime: 2021-07-05 23:47
 * @Description: 反转链表
 */
public class reverseList {

    //头插法，有点难理解
    public ListNode reverse1(ListNode head){
        ListNode headNode = new ListNode(-1);
        headNode.next = null;
        while (head != null){
            ListNode tmp = head;
            head = head.next;
            tmp.next = headNode.next;
            headNode.next = tmp;
        }
        return headNode.next;

    }


    //尾插法，也叫双指针迭代，相当于直接改变指针指向
    public ListNode reverse2(ListNode head){
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //递归
}
