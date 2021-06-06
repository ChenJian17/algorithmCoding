package com.chenjian.cn.backtracking;//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 715 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return result;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return result;
    }

    public void backtracking(int[] nums){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (i>0 && nums[i]==nums[i-1] && used[i-1]==true)
                continue;
            if (used[i] == false){//这是排除法，一层中只能取一个，从0开始
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums);
                path.remove(path.size()-1);
                used[i] = false;
            }


        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
