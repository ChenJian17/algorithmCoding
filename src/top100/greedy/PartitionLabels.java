package top100.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/7 23:16
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] last = new int[24];
        for (int i = 0; i<chars.length; i++){
            last[chars[i]-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i<chars.length; i++){
            end = Math.max(end, last[chars[i]-'a']);
            if (i == end){
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}
