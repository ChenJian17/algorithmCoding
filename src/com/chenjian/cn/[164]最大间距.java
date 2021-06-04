package com.chenjian.cn;//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
// 如果数组元素个数小于 2，则返回 0。 
//
// 示例 1: 
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 
//
// 示例 2: 
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。 
//
// 说明: 
//
// 
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。 
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。 
// 
// Related Topics 排序 
// 👍 354 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution164 {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        int max = -1, min = Integer.MAX_VALUE;
        for(int k: nums){
            min = Math.min(min,k);
            max = Math.max(max,k);
        }

        // 排除nums全部为一样的数字，nums = [1,1,1,1,1,1];
        if (max - min == 0) return 0;
        // 用于存放每个桶的最大值
        int[] bucketMin = new int[nums.length - 1];
        // 用于存放每个桶的最小值
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        // 确定桶的间距
        int interval = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        for(int i=0; i<nums.length-1; i++){
            int index = (nums[i]-min)/interval;
            if(nums[i]== min || nums[i]==max)
                continue;
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
        }

        // maxGap 表示桶之间最大的差距
        int maxGap = 0;
        // preMax 表示前一个桶的最大值
        int preMax = min;
        for(int i =0; i < nums.length-1; i++){
            if(bucketMax[i] == -1) continue;
            maxGap = Math.max(bucketMin[i]-preMax,maxGap);
            preMax = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max-preMax);
        return maxGap;





    }
}
//leetcode submit region end(Prohibit modification and deletion)
