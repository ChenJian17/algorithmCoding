package top100.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/3 00:05
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0, right = matrix[0].length-1; //左右边界
        int top = 0, bottom = matrix.length-1;  //上下边界

        List<Integer> res = new ArrayList<>();
        while (true){
            for (int i = left; i<=right; i++)
                res.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i<=bottom; i++)
                res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i>=left; i--)
                res.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i>=top; i--)
                res.add(matrix[i][left]);
            if (++left > right) break;
        }

        return res;

    }
}
