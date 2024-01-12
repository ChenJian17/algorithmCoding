package layOffDays.TwoPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/9 17:34
 */
public class SortColor_75 {
    public void sortColors(int[] nums) {

        int ptr = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        for (int i = ptr; i<nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

    }

    public void sortColors1(int[] nums) {
        int zero = 0, one = 0, two = nums.length-1;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, zero, one);
                zero++;
                one++;
            }else if (nums[one] == 1) {
                one++;
            }else {
                swap(nums, two, one);
                two--;
//                one++;
            }

        }


    }
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = temp;
        nums[right] = nums[left];
    }

}
