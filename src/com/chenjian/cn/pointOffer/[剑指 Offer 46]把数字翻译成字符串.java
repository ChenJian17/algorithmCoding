package com.chenjian.cn.pointOffer;//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// Related Topics 字符串 动态规划 
// 👍 245 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46_offer {
    int path = 0;
    Set<String> set;
    public int translateNum(int num) {
        String number = String.valueOf(num);
        set = new HashSet<>();
        for (int i=0; i<=25; i++)
            set.add(String.valueOf(i));
        DFS(number,0);
        return path;


    }
    public void DFS(String number, int start){
        if (start == number.length())
            path ++;


        for (int i = start; i<number.length(); i++){
            if (!set.contains(number.substring(start,i+1)))
                break;

            DFS(number, i+1);

        }

    }

    public static void main(String[] args) {
        new Solution46_offer().translateNum(506);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
