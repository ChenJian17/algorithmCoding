package com.chenjian.cn;//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 181 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution930 {
    int count = 0;
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (nums.length == 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0,ans = 0;

        for (int num: nums){
            pre += num;
            if (map.containsKey(pre-goal))
                ans += map.getOrDefault(goal-pre,0);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
