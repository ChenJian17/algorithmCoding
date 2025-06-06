package top100.binarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/10 23:46
 */
public class RotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target)
                return mid;

            // left - mid 是有序数组
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    right = mid-1;
                }else {
                    left = mid;
                }

            }else { // mid - right 是有序数组
                if (nums[mid] < target && target <= nums[nums.length-1]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;


    }
}
