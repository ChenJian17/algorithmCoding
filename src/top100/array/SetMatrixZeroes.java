package top100.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/31 10:49
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (Integer row: rowSet){
            Arrays.fill(matrix[row], 0);
        }

        for (Integer col: colSet){
            for (int i = 0; i< matrix.length; i++){
                matrix[i][col] = 0;
            }
        }


    }


    public void setZeroes1(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean row_flag = false, col_flag = false;
        for (int i = 0; i<row; i++){
            if (matrix[i][0] == 0)
                row_flag = true;
        }
        for (int i = 0; i<col; i++){
            if (matrix[0][i] == 0)
                col_flag = true;
        }

        for (int i = 1; i<row; i++){
            for (int j = 1; j<col; j++){
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for (int i = 1; i<row; i++){
            for (int j = 1; j<col; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

        }

        if (row_flag) {
            for (int i = 0; i<col; i++)
                matrix[0][i] = 0;
        }

        if (col_flag){
            for (int i = 0; i<row; i++)
                matrix[i][0] = 0;
        }
    }
}
