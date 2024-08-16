package top100.twoPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/11 14:33
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {

        int left = 0; // 指向第一个0元素
        while (left < nums.length) {
            while (left < nums.length && nums[left] != 0)
                left++;
            if (left == nums.length)
                break;
            int right = left+1; //指向第一个非0元素
            while (right < nums.length && nums[right] == 0)
                right++;
            if (right == nums.length)
                break;
            swap(nums,left,right);
            left = left+1;

        }

        for (int num: nums)
            System.out.println(num);


    }

    public void moveZeroes1(int[] nums) {
        if (nums == null)
            return;
        int j = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i<nums.length; i++){
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums){
        if (nums == null)
            return;
        int j = 0;
        for (int i = 0; i<nums.length; i++){
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }

    }

    public  void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        MoveZeroes_283 moveZeroes283 = new MoveZeroes_283();
        moveZeroes283.moveZeroes(nums);
    }
}
