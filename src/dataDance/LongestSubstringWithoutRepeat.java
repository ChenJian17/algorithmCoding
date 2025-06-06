package dataDance;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/10 21:07
 */
public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s){
        if (s.isBlank())
            return s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        int left = 0, right = 0;
        int[] tmp = new int[26];
        while (right < chars.length){
            char c = chars[right];

            tmp[c-'a'] ++;
            if (tmp[c-'a'] > 1){
                res = Math.max(right-left,res);
                Arrays.fill(tmp,0);
                tmp[c-'a'] = 1;
                left=right;
            }
            right++;

        }
        return res;

    }

    public int lengthOfLongestSubstring1(String s){
        //存储上一次出现的下标
        int[] last = new int[128];
        Arrays.fill(last,-1);
        int len = s.length();


        int left = 0, res = 0;
        for (int i = 0; i<len; i++){
            int index = s.charAt(i);
            if (last[index] != -1){
                left = Math.max(last[index]+1,left);
            }
            res = Math.max(res, i-left+1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abba";
        LongestSubstringWithoutRepeat repeat = new LongestSubstringWithoutRepeat();
        repeat.lengthOfLongestSubstring1(s);
    }
}
