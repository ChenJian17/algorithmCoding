package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/20 16:12
 */
public class SearchRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {

        if (nums.length == 0)
            return false;
        if (nums.length == 1)
            return target == nums[0];
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (nums[mid] == target)
                return true;
            if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }else if (nums[low] > nums[mid]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }else {
                low=low+1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,1,1};
        System.out.println(search(arr,0));
    }
}
