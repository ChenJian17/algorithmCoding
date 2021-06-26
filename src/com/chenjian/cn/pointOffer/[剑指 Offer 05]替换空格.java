package com.chenjian.cn.pointOffer;//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 102 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution05 {
    public static String replaceSpace(String s) {

        char[] res = s.toCharArray();
        String[] ans = new String[res.length];
        for (int i =0; i<res.length; i++){
            ans[i] = String.valueOf(res[i]);
        }

        for (int i =0; i<ans.length; i++){
            if (ans[i].equals(" ")){
                ans[i] = "%20";
            }
        }
        String sub = "";
        for (String a: ans){
            sub += a;
        }
        return sub;

    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
