package top100.binarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/31 08:58
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        while (left < right){
            mid = left + (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return mid;

    }
}
