package com.chenjian.cn.pointOffer;//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 416 👎 0


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution56_offer {
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            priorityQueue.offer(entry);
        }
        int[] res = new int[2];
        res[0] = priorityQueue.poll().getKey();
        res[1] = priorityQueue.poll().getKey();
        return res;

    }

    public int[] singleNumbers2(int[] nums){
        int ret = 0;//0与任何数异或等于他本身

        for (int num: nums){
            ret ^= num;
        }

        int index = 1;
        while ((ret&index) == 0 ){
            index = index << 1;
        }
        int a =0, b =0;
        for (int num: nums){
            if ((num&index) == 0)
                a ^= num;
            else
                b ^= num;
        }
        int[] res = new int[]{a,b};
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
