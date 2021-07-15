package com.chenjian.cn;//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2483 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    public int trap(int[] height) {

        int res = 0;
        for (int i=0; i<height.length; i++){
            if (i == 0 || i == height.length-1)
                continue;

            int left=height[i], right=height[i];
            for (int k=0; k<i; k++){
                if (height[k]>left)
                    left = height[k];
            }
            for (int k=i+1; k<height.length; k++){
                if (height[k] > right)
                    right = height[k];
            }

            res += Math.min(left,right)-height[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        new Solution42().trap(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
