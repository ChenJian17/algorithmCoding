package com.chenjian.cn.pointOffer;//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 103 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution21 {


    public int[] exchange(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i =0; i< nums.length; i++){
            if (nums[i] % 2 == 0){
                list1.add(nums[i]);
            }else {
                list2.add(nums[i]);
            }
        }

        list2.addAll(list1);
        int[] result = new int[nums.length];
        for (int i = 0; i < list2.size(); i++){
            result[i] = list2.get(i);
        }
        return result;


    }

    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length-1;
        int[] result = new int[nums.length];
        for (int t = 0; t<nums.length; t++){
            if (nums[t] %2 != 0){
                result[i] = nums[t];
                i++;
            }else {
                result[j] = nums[t];
                j --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
