package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/22 20:32
 */
public class FindMinRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (nums[mid] > nums[high]) {
                low = mid;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            }else {
                high--;
            }
        }

        return nums[low];

    }
}
