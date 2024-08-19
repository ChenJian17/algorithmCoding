package top100.slidingWindow;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/16 23:06
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;
        char[] arr = s.toCharArray();

        int left = 0, right = 0;
        LinkedList<Character> tmp = new LinkedList<>();
        tmp.add(arr[right]);

        int res = tmp.size();

        while (right < arr.length-1){
            right++;
            while (left <= right && tmp.contains(arr[right])){
                tmp.removeFirst();
                left++;
            }
            tmp.add(arr[right]);
            res = Math.max(res,tmp.size());
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
