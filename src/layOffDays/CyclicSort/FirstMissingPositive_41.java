package layOffDays.CyclicSort;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/23 23:56
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i<nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != (i+1))
                return i+1;
        }
        return nums.length+1;

    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
