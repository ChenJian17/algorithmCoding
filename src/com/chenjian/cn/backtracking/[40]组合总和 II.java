package com.chenjian.cn.backtracking;//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 587 👎 0


import java.time.chrono.MinguoDate;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution40 {
//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    Set<List<Integer>> set = new HashSet<>();
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        if (candidates == null || candidates.length == 0)
//            return result;
//        Arrays.sort(candidates);
//        backtracking(candidates, target, 0, 0);
//        for (List<Integer> list: set)
//            result.add(list);
//        return result;
//
//    }
//    public void backtracking(int[] candidates, int target, int index, int sum){
//        if (sum > target)
//            return;
//        if (sum == target){
//            set.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i =index; i<candidates.length; i++){
//            sum += candidates[i];
//            path.add(candidates[i]);
//            backtracking(candidates, target, i+1, sum);
//            sum -= candidates[i];
//            path.remove(path.size()-1);
//        }
//    }


    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, used);
        return result;

    }

    public void backtracking(int[] candidates, int target, int index, int sum, boolean[] used){
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i<candidates.length && (sum+candidates[i]<=target); i++){
            if (i>0 && candidates[i] == candidates[i-1] && used[i-1] == false)
                continue;
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates,target,i+1,sum,used);
            path.remove(path.size()-1);
            used[i] = false;
            sum -= candidates[i];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
