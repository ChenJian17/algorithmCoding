package com.chenjian.cn;//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 312 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution151 {
    public static String reverseWords(String s) {

        int first = 0;
        s = " "+s+" ";
        List<String> list = new ArrayList<>();
        for (int i =1; i<s.length(); i++){
            if (s.charAt(i-1) == ' ' && s.charAt(i)!=' '){
                first = i;
            }
            if (s.charAt(i) == ' ' && s.charAt(i-1)!= ' '){
                list.add(s.substring(first,i));
            }
        }
        String result = "";
        for (int i=list.size()-1; i>=0; i--){
            result += list.get(i)+" ";
        }
        return result.substring(0,result.length()-1);

    }

    public static void main(String[] args) {
        String s = "the sky is blue";
//        System.out.println(s.substring(0,3));
//        System.out.println(s.substring(4,7));
        System.out.println(reverseWords(s));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
