package com.chenjian.cn;//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数学 动态规划 
// 👍 328 👎 0


import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <2) return false;
        for (int i=1; i<nums.length; i++){
            nums[i] = nums[i]+nums[i-1];
        }
        for (int i=0; i<nums.length; i++){
            if (i >=1 && nums[i] % k ==0) return true;
            for (int j=0; j<i; j++){
                int temp = nums[i]-nums[j];
                if ((i-j)>=2 && temp % k == 0)
                    return true;
            }
        }
        return false;

    }
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums.length <2) return false;
        int[] sum = new int[nums.length+1];
        for (int i=1; i<=nums.length; i++)
            sum[i] = sum[i-1]+nums[i-1];
        Set<Integer> set = new HashSet<>();
        for (int i=2; i<=nums.length; i++){
            set.add(sum[i-2]%k);
            if (set.contains(sum[i]%k))
                return true;
        }
        return false;

    }

    public boolean checkSubarraySum3(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum =0;
        for (int i=0; i<nums.length; i++){
            preSum += nums[i];
            int mod = preSum%k;
            if (map.containsKey(mod)){
                if (i-map.get(mod) >=2)
                    return true;

            }else {
                map.put(mod, i);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,0,4,0,4,0};
        System.out.println(new Solution523().checkSubarraySum(arr, 5));
        System.out.println("============");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
