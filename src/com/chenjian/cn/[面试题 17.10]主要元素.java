package com.chenjian.cn;//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 154 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17_10 {
    public int majorityElement(int[] nums) {
        quickSort(nums,0,nums.length-1);
        if (nums.length <= 2)
            return nums[nums.length/2];
        int left = 0, right = 0;
        double tmp = (double)nums.length/(double)2;
        while (left < nums.length && right < nums.length){
            if (nums[left] == nums[right]){
                right ++;
                if ((right-left)>= tmp)
                    return nums[nums.length/2];
            }else {
                int len = right-left;
                if (tmp <= len)
                    return nums[nums.length/2];
                else {
                    left = right;

                }

            }
        }
        return -1;

    }

    public void quickSort(int[] nums, int start, int end){
        if (start >= end)
            return;
        int left = start, right = end;
        int pivot = nums[left];
        while (left < right){
            while (left < right && pivot <= nums[right])
                right --;
            nums[left] = nums[right];
            while (left < right && pivot >= nums[left])
                left ++;
            nums[right] = nums[left];

        }

        nums[left] = pivot;
        quickSort(nums, start, left-1);
        quickSort(nums, left+1, end);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        new Solution17_10().majorityElement(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
