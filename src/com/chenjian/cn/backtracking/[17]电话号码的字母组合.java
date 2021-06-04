package com.chenjian.cn.backtracking;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1323 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return result;
        backtracking(digits, 0);
        return result;

    }

    public void backtracking(String digits, int index){
        if (index == digits.length()){
            result.add(path.toString());
            return;
        }
        int next = digits.charAt(index) - '0';
        String temp = letterMap[next];
        for (int i=0; i<temp.length(); i++){
            path.append(temp.charAt(i));
            backtracking(digits, index+1);
            path.deleteCharAt(path.length()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
