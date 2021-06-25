package com.chenjian;

/**
 * Created by chenjian on 2021/3/13 19:08
 */
public class QuitSortDemo {

    public void quickSort(int[] nums, int start, int end){
        if (start >= end) return;
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
        quickSort(nums, start, left-1);
        quickSort(nums, left+1, end);
    }






    public static void main(String[] args) {
        int[] nums = new int[]{};


    }
}
