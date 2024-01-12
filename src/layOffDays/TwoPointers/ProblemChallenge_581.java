package layOffDays.TwoPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/12 23:24
 */
public class ProblemChallenge_581 {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < nums.length) {
            if (nums[i] < nums[i+1]) {
                i++;
            }else
                break;
        }
        while (j >= 0) {
            if (nums[j] > nums[j-1]) {
                j--;
            }else
                break;
        }
        if (i == nums.length-1 && j == 0){
            return 0;
        }

        int left = i, right = j;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = i; k<j; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }

        while (i > 0) {
            if (min < nums[i-1]){
                i--;
            }else
                break;
        }
        while (j < nums.length-1) {
            if (max > nums[j+1]) {
                j++;
            }else
                break;
        }
        return j-i+1;

    }
}
