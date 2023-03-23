package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 双指针 字符串 
// 👍 276 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution58I {
    public String reverseWords(String s) {
        s = s.trim();
        String[] newStr = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = newStr.length-1; i>=0; i--){
            res.append(newStr[i]);
            res.append(" ");
        }
        return res.toString().trim();

    }
    public String reverseWords2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
//leetcode submit region end(Prohibit modification and deletion)
