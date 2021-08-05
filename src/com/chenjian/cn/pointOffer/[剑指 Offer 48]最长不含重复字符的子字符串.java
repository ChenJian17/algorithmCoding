package com.chenjian.cn.pointOffer;//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 234 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution48_offer {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;
        int count = 0;

        for (int i=0; i<s.length(); i++){
            for (int j=i+1; j<s.length(); j++){
                String sb = s.substring(i,j);
                if (!sb.contains(String.valueOf(s.charAt(j)))){
                    count = Math.max(count,sb.length()+1);
                }else
                    break;
            }
        }
        return count;

    }


    public int lengthOfLongestSubstring2(String s){

        int left = 0, right = 0, count = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
            char c = s.charAt(right++);
            while (set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            count = Math.max(count,right-left);
        }
        return count;

    }

    public int lengthOfLongestSubstring3(String s){
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        while (right < s.length()){
            char c = s.charAt(right++);

            while (set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            count = Math.max(count,right-left);
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution48_offer().lengthOfLongestSubstring("abcabcbb");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
