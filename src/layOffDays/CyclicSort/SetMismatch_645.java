package layOffDays.CyclicSort;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/22 20:05
 */
public class SetMismatch_645 {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i<nums.length; i++) {
            while (nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != (i+1)) {
                res[0] = nums[i];
                res[1] = i+1;
                break;
            }
        }
        return res;


    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
