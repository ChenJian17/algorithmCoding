package com.chenjian.cn;//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 252 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution38 {
    public String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        backtrack(s.toCharArray(), "", visited, res);
        return res.toArray(new String[res.size()]);

    }

    private void backtrack(char[] arr, String temp, boolean[] visited, Set<String> res){
        if (temp.length() == arr.length){
            res.add(temp);
            return;
        }

        for (int i =0; i<arr.length; i++){
            if (visited[i])
                continue;
            visited[i] = true;
            backtrack(arr, temp+arr[i], visited, res);
            //回溯
            visited[i] = false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
