package com.chenjian.cn.pointOffer;//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 270 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        //特判
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        //初始化，定影上下左右四个边界，
        //随着螺旋打印的进行，上边界会往下压，即数值变大；下边界会往上升，即数值变小；
        // 左边界会往右靠，数值变大，右边界会往左靠，数值变小
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        int[] res = new int[matrix.length*matrix[0].length];
        //定义结果数组的下标从零开始
        int index = 0;
        while (true){
            //从左到右：上边界
            for (int i = left; i<= right; i++)
                res[index++] = matrix[top][i];
            if (++top > bottom)
                break;
            //从上到下：右边界
            for (int i= top; i<= bottom; i++)
                res[index++] = matrix[i][right];
            if (--right < left)
                break;
            //从右到左：下边界
            for (int i= right; i>=left && top<=bottom; i--)
                res[index++] = matrix[bottom][i];
            if (--bottom < top)
                break;
            //从下到上：左边界
            for (int i= bottom; i>=top && left <= right; i--)
                res[index++] = matrix[i][left];
            if (++left > right)
                break;
        }
        return res;

    }

    public int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[u][i];
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[d][i];
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
