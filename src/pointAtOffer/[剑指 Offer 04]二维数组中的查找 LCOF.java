package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 906 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int i = matrix.length-1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i --;
            }else if (matrix[i][j] < target) {
                j ++;
            }else {
                return true;
            }
        }
        return false;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
