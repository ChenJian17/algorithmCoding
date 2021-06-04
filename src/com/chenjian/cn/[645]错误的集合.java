package com.chenjian.cn;//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 哈希表 数学 
// 👍 162 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution645 {
    public static int[] findErrorNums(int[] nums) {
        int count = 0;
        int n = nums.length;
        while (n > 0){
            count += n;
            n--;
        }
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        count = count - nums[0];
        set.add(nums[0]);
        for (int i = 1; i< nums.length; i++){
            if (set.contains(nums[i])){
                result[0] = nums[i];
            }
            set.add(nums[i]);
            count = count - nums[i];

        }
        result[1] =result[0]+count;
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,4};
        findErrorNums(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
