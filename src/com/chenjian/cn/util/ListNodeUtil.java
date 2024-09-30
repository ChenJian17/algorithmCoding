package com.chenjian.cn.util;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/17 00:00
 */
public class ListNodeUtil {

    public static ListNode constructList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        for (int i = 0; i < nums.length; i ++) {
            ListNode currNode = new ListNode(nums[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }
        return dummy.next;
    }

    public static void print(ListNode node){
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        String input = "802";

        // 遍历字符串
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            int num = character;
            System.out.println(num);
            // 检查字符是否为数字
            if (Character.isDigit(character)) {
                System.out.println(character);
            }
        }
    }

}

