package top150;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/16 20:19
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if(numRows < 2)
            return s;

        List<StringBuilder> row = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            row.add(new StringBuilder());
        }
        int index = 0, flag = 1;
        for(char c: s.toCharArray()){
            row.get(index).append(c);
            index += flag;
            if(index == 0 || index == numRows-1) flag = -flag;

        }

        StringBuilder res  = new StringBuilder();
        for(StringBuilder item : row){
            res.append(item);
        }
        return res.toString();

    }

    public static void main(String[] args) {

    }
}
