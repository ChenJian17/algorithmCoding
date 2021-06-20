package com.chenjian.cn.backtracking;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1837 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;
        backtracking(res, "", n, n);
        return res;
    }
    public void backtracking(List<String> res, String track, int left, int right){
        if(left > right)
            return;
        if (left <0 || right <0)
            return;
        if (left == 0 && right == 0){
            res.add(track);
            return;
        }

        backtracking(res, track+"(",left-1, right);
        backtracking(res, track+")", left, right-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
