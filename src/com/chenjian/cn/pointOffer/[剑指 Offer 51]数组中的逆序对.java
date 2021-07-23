package com.chenjian.cn.pointOffer;//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 467 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        merge(nums,0,nums.length-1);
        System.out.println(count);
        return count;

    }
    public void merge(int[] nums, int start, int end){
        int mid = start+((end-start)>>1);
        if (start < end){
            merge(nums, start, mid);
            merge(nums, mid+1, end);
            sort(nums,start,end,mid);
        }
    }

    public void sort(int[] nums, int start, int end, int mid){
        int left = start, right = mid+1;
        int cur = 0;
        int[] temp = new int[end-start+1];
        while (left <= mid && right <= end){
            if (nums[left] <= nums[right]){
                temp[cur++] = nums[left++];
            }else {
                count += (mid-left+1);
                temp[cur++] = nums[right++];
            }
        }

        while (left <= mid){
            temp[cur++] = nums[left++];
        }
        while (right <= end){
            temp[cur++] = nums[right++];
        }
        for (int k=0; k<temp.length; k++){
            nums[start+k] = temp[k];
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,1};
        new Solution51().reversePairs(arr);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
