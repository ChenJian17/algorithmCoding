package layOffDays.CyclicSort;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/18 22:09
 */
public class FindDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int n = nums.length-1;
        while (n > 0) {
            res ^= (n--);
        }
        return res;
    }
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre = 0;
        while (slow != pre) {
            slow = nums[slow];
            pre = nums[pre];
        }
        return pre;
    }
}
