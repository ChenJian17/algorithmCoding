package com.chenjian.cn;//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 143 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution383 {
    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i<magazine.length(); i++){
            if (!map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),1);
            }else {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            }
        }

        for (int i =0; i<ransomNote.length(); i++){
            if (map.containsKey(ransomNote.charAt(i))){
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
                int value = map.get(ransomNote.charAt(i));
                if (value<0)
                    return false;

            }else
                return false;
        }
        return true;

    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (int i =0; i<magazine.length(); i++){
            array[magazine.charAt(i)-'a'] ++;
        }

        for (int i=0; i<ransomNote.length(); i++){
            array[ransomNote.charAt(i)-'a'] --;
            if (array[ransomNote.charAt(i)-'a'] <0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String string1 = "aa";
        String string2 = "aab";
        canConstruct(string1, string2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
