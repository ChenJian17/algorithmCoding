package top100.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/7 23:40
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(List.of(1));

        for (int i = 1; i<numRows; i++){
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for (int j = 1; j<i; j++){
                int tmp = res.get(i-1).get(j)+res.get(i-1).get(j-1);
                row.add(tmp);
            }
            row.add(1);
            res.add(row);
        }
        return res;


    }
}
