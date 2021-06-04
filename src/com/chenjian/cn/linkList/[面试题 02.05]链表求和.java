package com.chenjian.cn.linkList;//给定两个用链表表示的整数，每个节点包含一个数位。
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 59 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.chenjian.cn.util.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution02 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        int carray = 0;

        while (l1 != null || l2 != null){
            int num1 = l1 == null ? 0 :l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1+num2+carray;
            ListNode node = new ListNode(num%10);
            cur.next = node;
            cur = node;
            carray = num/10;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;

        }
        if (carray == 1)
            cur.next = new ListNode(1);

        return ans.next;




    }

    private ListNode reverse(ListNode head) {
        ListNode cur = null;
        while (head != null) {

            ListNode nextNode = head.next;
            head.next = cur;
            //后面这两行的cur跟head是会移动的
            cur = head;
            head = nextNode;
        }
        return cur;
    }

    public static Stack buildStack(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        return stack;

    }

    public static void main(String[] args) {
        String s = "Hello World";
//        通过length方法获取字符串长度
        for (int i = 0;i < s.length();i++){
            //charAt是获取字符串第i个字符
            System.out.println(s.charAt(i));
        }

        int[] array1 = new int[]{2,4,3};
        int[] array2 = new int[]{5,6,4};
        ListNode head1 = new ListNode(-1);
        ListNode cur = head1;
        for (int i =0; i< array1.length;i++){
            ListNode temp = new ListNode(array1[i]);
            cur.next = temp;
            cur = temp;
        }

        ListNode head2 = new ListNode(-1);
        ListNode cur1 = head2;
        for (int i =0; i< array2.length;i++){
            ListNode temp = new ListNode(array2[i]);
            cur1.next = temp;
            cur1 = temp;
        }
        addTwoNumbers(head1.next, head2.next);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
