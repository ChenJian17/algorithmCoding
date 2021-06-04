package com.chenjian.cn;//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 54 👎 0


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1714 {
    public int[] smallestK(int[] arr, int k) {
       if (k == 0)
           return new int[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1,num2) -> num1-num2);
        for (int i = 0; i<k; i++)
            priorityQueue.offer(arr[i]);

        for (int i = k; i<arr.length; i++){
            if (priorityQueue.peek() > arr[i]){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i =0; i<priorityQueue.size(); i++)
            res[i] = priorityQueue.poll();
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
