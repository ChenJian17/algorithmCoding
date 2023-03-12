package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 数学 双指针 字符串 
// 👍 366 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        String s1 = s.substring(0,n);
        String s2 = s.substring(n);
        res.append(s2);
        res.append(s1);
        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
