package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/15 22:07
 */
public class NumberRange_34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        int low = 0, high = nums.length;
        // get the left bound
        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] < target) {
                low = mid+1;
            }else if (nums[mid] > target) {
                high = mid;
            }else if (nums[mid] == target) {
                high = mid;
            }
        }
        if (low >= nums.length || nums[low] != target)
            res[0] = -1;
        else
            res[0] = low;


        int left = 0, right = nums.length;
        // get the right bound
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < target) {
                left = mid+1;
            }else if (nums[mid] > target) {
                right = mid;
            }else if (nums[mid] == target) {
                left = mid+1;
            }
        }
        if (left == 0 || nums[left-1] != target)
            res[1] = -1;
        else
            res[1] = left-1;

        return res;

    }
}
