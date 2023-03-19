package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 二分查找 
// 👍 784 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length-1;
        while (i < j) {
            int m = (i+j)/2;
            if (numbers[m] < numbers[j]){
                j = m;
            }else if (numbers[m] > numbers[j]) {
                i = m+1;
            }else {
                j = j-1;
            }
        }
        return numbers[i];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
