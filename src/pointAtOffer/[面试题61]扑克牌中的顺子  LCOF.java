package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 排序 
// 👍 316 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num: nums){
            if (num == 0)
                continue;
            if (set.contains(num))
                return false;
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        return max-min < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
