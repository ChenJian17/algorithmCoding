package com.chenjian.cn.bitwise;//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 381 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 好好理解什么是位运算.
// 每执行一次x = x&(x-1)，效果 使得 x二进制的最后一个 “1”变为零。
class Solution461 {
    public int hammingDistance(int x, int y) {
        int aox = x^y;
        int res =0;
        while (aox != 0){
            res++;
            aox &= aox-1;
        }
        return res;

    }

    public int hammingDistance2(int num1, int num2) {
        int tmp = num1 ^ num2;
        int sum = 0;
        while (tmp != 0){
            if ((tmp & 1) == 1)
                sum ++;
            tmp = tmp >> 1;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
