package top100.twoPointers;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/13 21:01
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i<nums.length; i++){
            if (nums[i] > 0)
                break;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = nums.length-1;
            while (left < right){
                int tmp = nums[i]+nums[left]+nums[right];
                if (tmp > 0){
                    right--;
                }else if (tmp < 0){
                    left ++;
                }else {
                    res.add(List.of(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
