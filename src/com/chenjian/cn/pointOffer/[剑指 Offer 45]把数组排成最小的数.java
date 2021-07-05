package com.chenjian.cn.pointOffer;//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 
// 👍 239 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution45 {
    public String minNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareString(o1,o2);
            }
        });
        for (int num: nums){
            queue.offer(String.valueOf(num));
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();

    }

    public int compareString(String str1, String str2){
        String a = str1+str2;
        String b = str2+str1;
        if (Long.valueOf(a) < Long.valueOf(b))
            return -1;
        else
            return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{121,12};
        new Solution45().minNumber(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
