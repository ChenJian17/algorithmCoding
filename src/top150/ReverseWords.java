package top150;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/12 21:44
 */
public class ReverseWords {

    public String reverseWords(String s) {

        List<String> list = new ArrayList<>();

        int start = 0;

        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
            }else {
                start = i;
                while(start < s.length() && s.charAt(start) != ' '){
                    start ++;
                }
                list.add(s.substring(i, start));
                i = start;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int j = list.size()-1; j>=0; j--){
            res.append(list.get(j));
            if(j != 0){
                res.append(" ");
            }

        }
        return res.toString();
    }
}
