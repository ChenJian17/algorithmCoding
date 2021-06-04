package com.chenjian.cn;//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 859 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution28 {
    public static int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        for (int i = 0; i<haystack.length(); i++){
            int index = i;
            for (int j =0; j<needle.length(); j++){
                if (index< haystack.length()&&haystack.charAt(index) == needle.charAt(j))
                    index++;
                else
                    break;

            }
            if (index-i == needle.length())
                return i;
        }
        return -1;

    }


    public static int strStr2(String haystack, String needle){
        int n = haystack.length(), m = needle.length();
        for (int i =0; i<= n-m; i++){
            int a =i, b =0;
            while (b<m && haystack.charAt(a) == needle.charAt(b)){
                a++;
                b++;
            }
            if (b == m)
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {
//        String haystack = "mississippi";
//        String needle = "issip";
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(strStr(haystack, needle));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
