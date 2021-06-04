package com.chenjian.cn.backtracking;//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 581 👎 0


import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution90 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used, 0);
        return result;

    }

    void backtracking(int[] nums, boolean[] used, int startIndex){
        result.add(new ArrayList<>(path));

        for (int i=startIndex; i<nums.length; i++){
            if (i>0 && nums[i] == nums[i-1] && used[i-1] == false)
                continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, i+1);
            path.remove(path.size()-1);
            used[i] = false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
