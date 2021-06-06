package com.chenjian.cn.backtracking;//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
//
// 
//
// 示例： 
//
// 
//输入：[4, 6, 7, 7]
//输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]
//] 
//
// 
//
// 提示： 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 290 👎 0


import com.chenjian.cn.util.ListNode;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;

    }
    public void backtracking(int[] nums, int startIndex){
        if (path.size() > 1)
            result.add(new ArrayList<>(path));

        int[] used = new int[201];
        for (int i=startIndex; i<nums.length; i++){
            if ((!path.isEmpty() && nums[i]<path.get(path.size()-1)) || (used[nums[i]+100] == 1))
                continue;
            path.add(nums[i]);
            used[nums[i]+100] = 1;
            backtracking(nums, i+1);
            path.remove(path.size()-1);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
