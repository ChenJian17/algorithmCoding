package com.chenjian.cn.binarySearch;//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 动态规划 
// 👍 1190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {
    int[][] meno;
    public int numTrees(int n) {
        meno = new int[n+1][n+1];
        return traverse(1, n);

    }
    int traverse(int start, int end){
        if (start > end)
            return 1;
        if (meno[start][end] != 0)
            return meno[start][end];
        int res = 0;
        for (int i=start; i<=end; i++){
            int left = traverse(start, i-1);
            int right = traverse(i+1, end);
            res += left*right;
        }
        meno[start][end] = res;
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
