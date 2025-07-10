package top100.trick;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/15 10:52
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len-1;
        while (left < right){
            int mid = (left+right)/2;
            int count = 0;
            for (int num: nums){
                if (num <= mid)
                    count++;
            }
            if (count > mid){
                right = mid;
            }else {
                left = mid+1;
            }
        }

        return left;

    }
}
