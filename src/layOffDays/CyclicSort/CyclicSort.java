package layOffDays.CyclicSort;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/13 23:22
 */
public class CyclicSort {

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i]-1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            }else {
                i ++;
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
