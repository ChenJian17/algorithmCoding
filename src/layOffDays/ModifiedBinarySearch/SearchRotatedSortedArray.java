package layOffDays.ModifiedBinarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/19 23:35
 */
public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (nums[mid] == target)
                return mid;

            if (nums[0] <= nums[mid]) { //left
                if (nums[0] <= target && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }else {
                if (target <= nums[nums.length-1] && target > nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,3};
        System.out.println(search(arr,3));
    }
}
