package top100.array;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/27 23:22
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        int[] res = new int[nums.length];
        for (int i = nums.length-k; i<nums.length; i++){
            res[i-k] = nums[i];
        }
        for (int i = 0; i<k; i++){
            res[k] = nums[i];
        }

        for (int i = 0; i<nums.length; i++){
            nums[i] = res[i];
        }

    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,nums.length-k-1);
        reverse(nums,k,nums.length-1);

    }

    private void reverse(int[] nums, int left, int right){
        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            right --;
            left ++;
        }
    }
}
