package top100.trick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/14 20:42
 */
public class NextPermutation {

    List<Integer> res = new ArrayList<>();
    boolean[] flag;

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i --;
        }
        int small = nums[i];

        if (i >= 0){
            int j = nums.length-1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start){
        int left = start, right = nums.length-1;
        while (left < right){
            swap(nums,left,right);
            left ++;
            right --;
        }
    }

    public void DFS(int[] nums,StringBuilder sb){
        if (sb.length() == nums.length){
            res.add(Integer.valueOf(sb.toString()));
            return;
        }

        for (int i = 0; i<nums.length; i++){
            if (flag[i])
                continue;
            sb.append(nums[i]);
            flag[i] = true;
            DFS(nums,sb);
            flag[i] = false;

        }
    }
}
