package dataDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/12 21:05
 */
public class LeetCode128 {

    public int longestConsecutive(int[] nums){
        Arrays.sort(nums);

        int left = 0, right = 1;
        int len = nums.length;
        if (len < 2)
            return len;
        int last = nums[0];
        int res = 0;

        int repeat = 0;
        while (right < len){
            if (nums[right]-last == 1){
                last = nums[right];
                res = Math.max(res, right-left+1-repeat);
            }else if (nums[right]-last == 0){
                repeat ++;
            }else {
                last = nums[right];
                left = right;
                repeat = 0;
            }
            right ++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
//        System.out.println(arr);
        LeetCode128 ob = new LeetCode128();
        ob.longestConsecutive(arr);
    }
}
