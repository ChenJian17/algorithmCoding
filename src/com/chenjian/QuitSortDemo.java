package com.chenjian;


import javax.sound.sampled.Line;

/**
 * Created by chenjian on 2021/3/13 19:08
 */
public class QuitSortDemo {

    //快速排序
    public void quickSort(int[] nums, int start, int end){
        if (start <= end)
            return;
        int left = start, right = end;
        int pivot = nums[left];
        while (left < right){
            while (nums[right] >= pivot)
                right --;
            nums[left] = nums[right];
            while (nums[left] <= pivot)
                left ++;
            nums[right] = nums[left];
        }
        //此时left == right
        nums[left] = pivot;
        quickSort(nums, start, left-1);
        quickSort(nums, left+1, end);
    }



    //归并排序
    public void sort(int[] nums, int start, int end){
        if (nums == null || start <= end)
            return;
        int mid = (start+end)/2;
        //分
        sort(nums, start, mid);
        sort(nums, mid+1, end);
        //治
        merge(nums,start,end,mid);
    }

    public void merge(int[] nums, int left, int right, int mid){
        //构建临时数组用于存放数据
        int[] temp = new int[right-left+1];
        //i是左边数组移动的下标，j是右边数组移动的下标，k是临时数组移动的下标
        int i = left, j = mid+1, cur = 0;

        while (i<=mid && j<= right){
            if (nums[i] < nums[j])
                temp[cur++] = nums[i++];
            else
                temp[cur++] = nums[j++];
        }
        //当左边数据有剩余
        while (i<=mid)
            temp[cur++] = nums[i++];
        //当右边数组有剩余
        while (j<=right)
            temp[cur++] = nums[j--];

        //将临时数组复制替换到原数组
        for (int k=0; k<cur; k++){
            nums[left+k] = temp[k];
        }
    }






    public static void main(String[] args) {
        int[] nums = new int[]{};


    }
}
