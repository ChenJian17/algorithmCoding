package com.chenjian.cn;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 230 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for(int i =0; i<len-1; i++){
            int minIndex = i;
            for(int j = i+1; j<len; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
        return nums;

    }
    public void swap(int[] nums, int min, int i){
        int temp = nums[i];
        nums[i] = nums[min];
        nums[min] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
