package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 位运算 数组 哈希表 数学 二分查找 
// 👍 358 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53II {
    public int missingNumber(int[] nums) {
        for (int i =0; i<nums.length; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return -1;

    }

    public int missingNumber2(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] != mid) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
