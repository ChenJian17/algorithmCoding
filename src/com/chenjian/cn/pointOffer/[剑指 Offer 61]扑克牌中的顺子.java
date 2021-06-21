package com.chenjian.cn.pointOffer;//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 106 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution61 {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for(int i =0; i<nums.length-1; i++){
            if(nums[i] == 0){
                zero++;
                continue;
            }
            int temp = nums[i+1] - nums[i];
            if(temp <= 0)
                return false;
            else if(temp > 1){
                if(temp > zero+1)
                    return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,2,5};
        System.out.println(isStraight(array));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
