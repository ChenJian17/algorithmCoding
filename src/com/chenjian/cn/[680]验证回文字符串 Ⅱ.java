package com.chenjian.cn;//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 336 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution680 {
    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i <= j){
            char ans = s.charAt(i);
            char bns = s.charAt(j);
            if (ans == bns){
                i++;
                j--;
            }else
                break;
        }
        return compare(i+1, j, s) || compare(i, j-1, s);

    }

    public static boolean compare(int left, int right, String string){
        while (left <= right){
            char aks = string.charAt(left);
            char bks = string.charAt(right);
            if (aks != bks)
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abca";
        validPalindrome(str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
