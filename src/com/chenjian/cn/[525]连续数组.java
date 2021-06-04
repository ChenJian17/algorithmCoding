package com.chenjian.cn;//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 385 👎 0



import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution525 {
    public int findMaxLength(int[] nums) {

        int[] sum = new int[nums.length+1];
        for (int i=1; i<=nums.length; i++){
            sum[i] = nums[i-1]+sum[i-1];
        }

        int maxLength = 0;
        for (int i=1; i<=nums.length; i++){
            for (int j=1; j<i; j++){
                int temp = sum[i] - sum[j]+nums[j-1];
                int ans = i-j+1;
                if (temp*2 == ans){
                    maxLength = Math.max(maxLength, i-j+1);
                }

            }
        }
        return maxLength;


    }

    public int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0, maxLength = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0)
                counter --;
            if (nums[i] == 1)
                counter ++;

            if (map.containsKey(counter)){
                maxLength = Math.max(maxLength, i-map.get(counter));
            }else{
                map.put(counter, i);
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,0,0,0,1,1};
//        int[] arr = new int[]{0,1};
        new Solution525().findMaxLength(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
