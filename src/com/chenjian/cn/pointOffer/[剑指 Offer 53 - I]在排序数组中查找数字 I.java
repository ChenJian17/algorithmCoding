package com.chenjian.cn.pointOffer;//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 145 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53_offer {
    int count = 0;
    public int search(int[] nums, int target) {
        helper(nums, target, 0, nums.length-1);
        return count;

    }

    public void helper(int[] nums, int target, int start, int end){
        if (start <= end){
            int mid = (start+end)/2;
            if (nums[mid] == target){
                count ++;
                helper(nums,target,start,mid-1);
                helper(nums,target,mid+1,end);
            }else if (nums[mid] > target){
                end = mid-1;
                helper(nums, target, start, end);
            }else{
                start = mid+1;
                helper(nums, target, start, end);
            }
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
