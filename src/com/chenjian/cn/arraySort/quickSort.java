package com.chenjian.cn.arraySort;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: com.chenjian.cn.arraySort
 * @Author: Joker
 * @CreateTime: 2021-07-20 22:33
 * @Description: 快排
 */
public class quickSort {

    public void partition(int[] nums, int start, int end){
        if (start >= end)
            return;
        int left = start, right = end;
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivot)
                right --;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot)
                left ++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        partition(nums,start,left-1);
        partition(nums,left+1,end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,6,3,5,3,3,8};
        new quickSort().partition(nums,0,nums.length-1);
    }
}
