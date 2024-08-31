package top100.array;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/30 23:40
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i<nums.length; i++){
            while (nums[i]>0 && nums[i]<= nums.length && i != (nums[i]-1)){
                swamp(nums,i, nums[i]-1);
            }
        }

        for (int i = 0; i<nums.length; i++){
            if (nums[i]-1 != i){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void swamp(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
