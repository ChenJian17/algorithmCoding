package com.chenjian.cn.pointOffer;//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 197 👎 0


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution56_offer1 {
    public int singleNumber(int[] nums) {
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

        return priorityQueue.poll().getKey();

    }


    public int singleNumber2(int[] nums){
        if (nums.length == 0) return -1;

        int[] bitmask = new int[32];
        for (int num: nums){
            int bit = 1;
            for (int i=31; i>=0; i--){
                if ((num&bit) == 1)
                    bitmask[i]++;
                bit <<= 1;
            }
        }

        int res = 0;
        for (int i=0; i<32; i++){
            res <<= 1;
            res = res+bitmask[i]%3;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
