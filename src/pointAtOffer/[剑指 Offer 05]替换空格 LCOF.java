package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 字符串 
// 👍 436 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution05 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i =0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == ' '){
                res.append("%20");
            }else {
                res.append(tmp);
            }

        }
        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
