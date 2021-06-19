package com.chenjian.cn.backtracking;//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 154 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1239 {
    int res = Integer.MIN_VALUE;
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String str: arr){
            int mask = 0;
            for (int i=0; i<str.length(); i++){
                int ch = str.charAt(i) - 'a';
                if (((mask >> ch)&1) != 0){
                    mask = 0;
                    break;
                }
                mask |= 1<<ch;
            }
            if (mask > 0)
                masks.add(mask);
        }

        backtracking(masks,0,0);
        return res;
    }

    public void backtracking(List<Integer> masks, int post, int mask){
        if (post == masks.size()){
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }

        if ((mask & masks.get(post)) == 0){
            backtracking(masks, post+1, mask|masks.get(post));
        }

        backtracking(masks, post+1, mask);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
