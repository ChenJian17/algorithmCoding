package com.chenjian.cn.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: com.chenjian.cn.nowcoder
 * @Author: Joker
 * @CreateTime: 2021-07-17 21:12
 * @Description: acm模式
 */
public class Acm {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//    }
    int sum = 0;
    public int getMaxValue (int[] nums, int[] values) {
        DFS(nums,values,0,nums.length-1,0,0);
        return sum;
    }

    public void DFS(int[] nums, int[] values, int left, int right, int num,int i){
        if (left > right){
            sum = Math.max(sum,num);
            return;
        }

        DFS(nums,values,left+1,right,num+nums[left]*values[i],i+1);
        DFS(nums,values,left,right-1,num+nums[right]*values[i],i+1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,4};
        int[] values = new int[]{1,2,3,4,5};
        new Acm().getMaxValue(nums,values);
    }
}
