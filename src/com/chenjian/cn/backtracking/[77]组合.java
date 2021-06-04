package com.chenjian.cn.backtracking;//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 581 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;

    }

    public void backtracking(int n, int k, int index){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=index; i<=n; i++){
            path.add(i);
            backtracking(n, k, i+1);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        new Solution77().combine(4,2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
