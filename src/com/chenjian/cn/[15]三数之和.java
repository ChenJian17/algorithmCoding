package com.chenjian.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3251 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(),visited, set);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list: set){
            result.add(list);
        }
        return result;


    }

    public static void backtrack(int[] nums, List<Integer> list, boolean[] visited,Set<List<Integer>> set){
        if (list.size() == 3){
            int num = 0;
            for (int n: list)
                num += n;
            if (num == 0)
                set.add(list);

            return;
        }

        for (int i =0; i<nums.length; i++){
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, visited, set);
            //回溯
            visited[i] = false;
        }

    }



    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i =0; i<n;i++){
            if (nums[i] > 0)
                return result;
            if (i>0 && nums[i]==nums[i-1])
                continue;

            int left = i+1, right = n-1;
            while (left < right){
                int temp = nums[i]+nums[left]+nums[right];
                if (temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left] == nums[left+1]) ++left;
                    while (left < right && nums[right] == nums[right-1]) --right;
                    left++;
                    right--;
                }else if (temp<0){
                    left ++;
                }else {
                    right ++;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
