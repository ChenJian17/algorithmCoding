package com.chenjian.cn;//对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
//
// 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。 
//
// 
//
// 示例 1： 
//
// 
//输入："13"
//输出："3"
//解释：13 的 3 进制是 111。
// 
//
// 示例 2： 
//
// 
//输入："4681"
//输出："8"
//解释：4681 的 8 进制是 11111。
// 
//
// 示例 3： 
//
// 
//输入："1000000000000000000"
//输出："999999999999999999"
//解释：1000000000000000000 的 999999999999999999 进制是 11。
// 
//
// 
//
// 提示： 
//
// 
// n的取值范围是 [3, 10^18]。 
// 输入总是有效且没有前导 0。 
// 
//
// 
// Related Topics 数学 二分查找 
// 👍 116 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int m = (int)(Math.log(num+1)/Math.log(2)); m>=2;m--){
            long left = 2,right = (long)Math.pow(num, 1.0 / (m-1)) + 1;
            while (left < right){
                long mid = left+(right-left)/2, sum = 0;
                for (int j=0; j<m; j++)
                    sum = sum*mid+1;
                if (sum == num){
                    return String.valueOf(mid);
                }else if (sum < num){
                    left = mid+1;
                }else
                    right = mid;
            }
        }
        return String.valueOf(num-1);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
