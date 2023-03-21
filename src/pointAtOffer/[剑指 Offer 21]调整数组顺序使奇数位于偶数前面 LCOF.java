package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 数组 双指针 排序 
// 👍 288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution21 {
    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right){
            while (left < right && nums[left]%2 != 0) {
                left ++;
            }
            while (left < right && nums[right]%2 == 0){
                right --;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4};
        exchange(num);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
