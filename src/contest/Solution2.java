package contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/18 11:22
 */
public class Solution2 {
    public int minSwaps(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++){
            fun(nums[i],map);
        }

        int count = 0;
        for (int i = 0; i<nums.length-1; i++){
            for (int j = i+1; j<nums.length; j++){
                int a = nums[i], b = nums[j];
                if (map.get(b) < map.get(a)){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    count++;
                }else if (map.get(b) == map.get(a)){
                    if (a > b){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        count++;
                    }
                }
            }
        }

        return count;


    }


    public void fun(int num, Map<Integer,Integer> map){
        int initial = num;
        int res = 0;
        while (num != 0){
            int tmp = num%10;
            num = num/10;
            res += tmp;
        }
        map.put(initial, res);
    }

    public static void main(String[] args) {
        int[] input = new int[]{18,43,34,16};
        Solution2 solution2 = new Solution2();
        solution2.minSwaps(input);
    }
}
