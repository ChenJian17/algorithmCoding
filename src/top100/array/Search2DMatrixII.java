package top100.array;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/4 08:57
 */
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = matrix.length-1, j = 0;

        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] < target){
                j++;
            }else if (matrix[i][j] > target){
                i --;
            }else {
                return true;
            }
        }
        return false;

    }
}
