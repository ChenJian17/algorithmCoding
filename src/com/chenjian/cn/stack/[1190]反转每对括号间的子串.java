package com.chenjian.cn.stack;//给出一个字符串 s（仅含有小写英文字母和括号）。
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 160 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1190 {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++){
            if (arr[i] == '(')
                stack.push(i);
            if (arr[i] == ')'){
                reverse(arr, stack.pop()+1, i-1);
            }
        }
        for (int i=0; i<arr.length; i++){
            if (arr[i] != '(' && arr[i] != ')')
                sb.append(arr[i]);
        }
        return sb.toString();

    }

    public void reverse(char[] arr, int start, int end){
        for (int i=start, j=end; i<j; i++,j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
