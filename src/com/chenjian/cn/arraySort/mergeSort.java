package com.chenjian.cn.arraySort;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: com.chenjian.cn.arraySort
 * @Author: Joker
 * @CreateTime: 2021-07-20 22:44
 * @Description: 归并排序
 */
public class mergeSort {

    public void sort(int[] nums, int start, int end){
        if (nums == null || start >= end)
            return;
        int mid = (start+end)/2;
        sort(nums,start,mid);
        sort(nums,mid+1,end);
        merge(nums,start,end,mid);

    }

    public void merge(int[] nums, int start, int end, int mid){
        int left = start, right = mid+1, cur = 0;
        int[] temp = new int[end-start+1];

        while (left <= mid && right <= end){
            if (nums[left] <= nums[right]){
                temp[cur++] = nums[left++];
            }else {
                temp[cur++] = nums[right++];
            }
        }

        while (left <= mid){
            temp[cur++] = nums[left++];
        }
        while (right <= end){
            temp[cur++] = nums[right++];
        }

        for (int k=0; k<cur; k++){
            nums[start+k] = temp[k];
        }

    }

}
