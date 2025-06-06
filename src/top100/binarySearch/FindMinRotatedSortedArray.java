package top100.binarySearch;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/11 22:18
 */
public class FindMinRotatedSortedArray {
    public int findMin(int[] nums){
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left+(right-left)/2;
            if (nums[mid] > nums[right]){
                left = mid+1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[left];

    }
}
