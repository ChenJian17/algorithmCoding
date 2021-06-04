package com.chenjian.cn;//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 322 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left =0, right = n-1, top = 0, bottom = n-1;
        int num =1;
        while (num <= n*n) {
            for(int i = left; i<= right; i++)
                result[top][i] = num++;
            top ++;
            for (int i = top; i<= bottom; i++)
                result[i][right] = num++;
            right --;
            for (int i = right; i>= left; i--)
                result[bottom][i] = num++;
            bottom --;
            for (int i = bottom; i>= top;i--)
                result[i][left] = num++;
            left ++;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
