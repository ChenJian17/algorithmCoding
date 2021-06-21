package com.chenjian.cn.pointOffer;//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 126 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map =new HashMap<>();

        for(int i =0; i<nums.length; i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i])+1);
            }

        }

        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
