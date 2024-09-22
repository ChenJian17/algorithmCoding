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

    private static volatile int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    add();
                }
            });
            thread.start();
        }
        // 等10个线程运行完毕
        Thread.sleep(1000);
        System.out.println(counter);
    }
    public synchronized static void add() {
        counter++;
    }

}

