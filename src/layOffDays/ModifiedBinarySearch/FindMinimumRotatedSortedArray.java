package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/20 18:00
 */
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {

        int n = nums.length-1;
        int low = -1, high = nums.length-1;
        while (low+1 < high) {
            int mid = low+(high-low)/2;
            if (nums[mid] < nums[n-1]) {
                high = mid;
            }else
                low = mid;
        }
        return nums[high];

    }
}
