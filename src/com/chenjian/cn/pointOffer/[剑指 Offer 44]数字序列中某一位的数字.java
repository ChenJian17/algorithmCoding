package com.chenjian.cn.pointOffer;//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 
// 👍 141 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution44_offer {
    public int findNthDigit(int n) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<=n; i++)
            str.append(i);
        char[] res = str.toString().toCharArray();
        return res[n]-'0';
    }

//    public int findNthDigit2(int n){
//        if (n<=9)
//            return n;
//        n -= 9;
//        int count = 1;
//
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
