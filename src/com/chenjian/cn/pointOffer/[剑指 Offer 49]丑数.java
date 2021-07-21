package com.chenjian.cn.pointOffer;//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution49_offer {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p1=0, p2=0, p3=0;
        int i = 1;
        while (i < n){
            res[i] = Math.min(Math.min(res[p1]*2,res[p2]*3),res[p3]*5);
            if (res[i] == res[p1]*2)
                p1++;
            if (res[i] == res[p2]*3)
                p2++;
            if (res[i] == res[p3]*5)
                p3++;
            i++;
        }
        return res[n-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
